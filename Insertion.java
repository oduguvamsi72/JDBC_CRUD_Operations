package jdbcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertion {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/register";
	private static final String user="root";
	private static final String pass="root";
	private static Connection conn;
	private static PreparedStatement pmst;

public static void main(String[] args) {
	try {
		Scanner scr=new Scanner(System.in);
		
		Class.forName(Driver);
		conn=DriverManager.getConnection(url, user, pass);
		
		String sql="insert into reg1(name,email,password)values(?,?,?)";
		
		pmst=conn.prepareStatement(sql);
		
		System.out.println("Enter Name");
		pmst.setString(1, scr.next());
		System.out.println("Enter Email");
		pmst.setString(2, scr.next());
		System.out.println("Enter Password");
		pmst.setString(3, scr.next());
		
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("Inserted.");
		}
		else {
			System.out.println("Not Inserted.");
		}
		
		pmst.close();
		conn.close();
		scr.close();
	} 
	catch (Exception e) {
    e.printStackTrace();
	}
	
}
}
