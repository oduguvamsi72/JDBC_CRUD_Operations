package jdbcc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyemail {
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
		
		System.out.println("Enter TableName:");
		String sql="select * from "+scr.next()+" where email=?";
		System.out.println("Enter Email:");
		pmst=conn.prepareStatement(sql);
		pmst.setString(1,scr.next());
		
		ResultSet rs=pmst.executeQuery();
		while(rs.next()) {
			System.out.println("id: "+rs.getInt("id"));
			System.out.println("Name: "+rs.getString("name"));
			System.out.println("Email: "+rs.getString("email"));
			System.out.println("Password: "+rs.getString("password"));
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