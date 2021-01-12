package itemStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Createdb {

	public void create(){
		 Connection con = null;
	     Statement stmt = null;
	     int result = 0;
	     
	     try {
	        Class.forName("org.hsqldb.jdbc.JDBCDriver");
	        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	        stmt = con.createStatement();
	        
	        result = stmt.executeUpdate("CREATE TABLE items(" + 
	        		"id integer identity," + 
	        		"name varchar(30) not null," + 
	        		"number varchar(30) not null," + 
	        		"cabinet integer not null);");
				
	     }  catch (Exception e) {
	        System.out.println("Table Already Created!!");
	        
	     }
	  }
}
