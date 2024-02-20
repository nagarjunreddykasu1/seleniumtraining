package datadriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.testng.annotations.Test;

import net.sourceforge.jtds.jdbc.Driver;

public class SQLServerDBTest {
	
	public Connection con;
	
	@Test
	public void TC_SQLServerDB() throws Exception {
		try {
			
			DriverManager.registerDriver(new Driver());
			con=DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.16:1521;databaseName=Circulus_QA;user=CirculusUser;password=Circulus$312");
			
			String query="SELECT * FROM PAYMENT_TERMS WHERE ACTIVE_FLAG='Y'";
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			ArrayList<Object> al=new ArrayList<>();
			while(rs.next()) {
				al.add(rs.getString("PAYMENT_TERM_NAME"));
				al.add(rs.getInt("id"));
			}
			
			
			
			
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	
	

}

/*

jdbc:jtds:sqlserver://<ipaddress>:<portnumber>;databaseName=<dbname>;user=<username>;password=<password>

*/