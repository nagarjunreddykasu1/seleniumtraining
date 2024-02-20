package datadriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class MySQLDBTest {
	
	public Connection con;
	
	
	@Test
	public void TC_MySQL_DB() throws Exception {
		try {
			
			String db_url="jdbc:mysql://192.168.1.16:1523/Circulus_QA";
			String username="CirculusUser";
			String password="Circulus$123";
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(db_url, username, password);
			
			String query="SELECT * FROM PAYMENT_TERMS WHERE ACTIVE_FLAG='Y'";
			
			Statement statement=con.createStatement();
			
			ResultSet rs=statement.executeQuery(query);
			
			ArrayList<String> al=new ArrayList<>();
			
			while(rs.next()) {
				al.add(rs.getString("PAYMENT_TERM_NAME"));
			}
			
			con.close();
			
			
			
		}
		catch(Exception e) {
			throw e;
		}
	}

}

/*

jdbc:mysql://<ipaddress>:<portnumber>/<databasename>





*/