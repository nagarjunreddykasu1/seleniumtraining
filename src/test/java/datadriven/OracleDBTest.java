package datadriven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.testng.annotations.Test;

import oracle.jdbc.pool.OracleDataSource;

public class OracleDBTest {
	public final static String DB_URL="jdbc:oracle:thin@192.168.1.15:1521:circulusqa";
	public final static String DB_UserName="circulusqa_user";
	public final static String DB_Password="Circulus$91827";
	public Connection con;
	
	@Test
	public void TC_OracleDB() throws Exception {
		
		try {
			OracleDataSource ds=new OracleDataSource();
			ds.setURL(DB_URL);
			ds.getConnection(DB_UserName, DB_Password);
			
			String query="SELECT * FROM PAYEMNT_TERMS WHERE ACTIVE_FLAG='Y'";
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			ArrayList<String> terms=new ArrayList<>();
			while(rs.next()) {
				terms.add(rs.getString("PEYMENT_TERMS_NAME"));
			}
			
			
		}
		catch(Exception e) {
			throw e;
		}
		
		
		
		
		
		
		
		
	}

}
//jdbc:oracle:thin:@<ipaddress>:<portnumber>:<dbname>

// jdbc:oracle:thin@192.168.1.15:1521:circulusqa
// ipaddress: 192.168.1.15 portnumber: 1521 dbname: circulusqa
//username: circulusqa_user	password: Circulus$91827