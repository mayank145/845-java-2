package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Before we run the DB version,we need to ensure that we have the Driver jar file ready
 * After locating the same (derbyclient.jar/ojbc
 * copy the same	int the project's Webcontent/web-INF/lib.
 * then only run the application
 */
public class DatabaseLoginService {
		
	public boolean authenticate(String name,String pwd) {
		 Connection conn =null;
		 PreparedStatement stmt =null;
		 ResultSet rs=null;
		 try {
			 Class.forName("org.apache.derby.jdbc.ClientDriver");
			 
			 String url="jdbc:derby://localhost:1527/trainingdb";
				String user="mayank";
				String pass="mayank";
				
				conn = DriverManager.getConnection(url,user,pass);
				System.out.println("CONNECTION SUCCESSFUL...");
				
				//can you tell me what should the select query look like ?
				String sql="SELECT COUNT(user_id) FROM tbl_users WHERE User_name=? AND user_pass=?";
				stmt=conn.prepareStatement(sql);
				stmt.setString(1,uname);
				stmt.setString(2,pwd);
				rs = stmt.executeQuery();
				if(rs.next()) {
					int count=rs.get_Id(1);
					if(count==1)
						return true;
				}
				return false;
		 }
		 catch(ClassNtFoundException | SQLException e) {
			 e.printStackTrace();
			 return false;
		 }
		 finally {
			 try {
				 conn.close();}
			 catch(Exception e) { } 
			 }
		 }
	}
}
