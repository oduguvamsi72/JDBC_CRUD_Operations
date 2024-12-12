package jdbcc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class deleterecord {
	
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
		String sql="delete from "+scr.next()+" where id=?";
		
		pmst=conn.prepareStatement(sql);
		
		System.out.println("Enter Id");
		pmst.setInt(1, scr.nextInt());
		
		
		int i=pmst.executeUpdate();
		if(i==0) {
			System.out.println("Successfully Deleted.");
		}
		else {
			System.out.println("Not Deleted.");
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
