package Com.DataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	private  static String url="jdbc:mysql://localhost:3306/carparkingmanagement";
	private  static String userName="root";
	private  static String password="";
	private  static Connection con;
	
	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,userName,password);
		  }
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static  void DbCOnnectioinClose()
	{
		try {
			con.close();
			System.out.println("  ");
			System.out.println("Connection is close....");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Connection is not close....");
		}
		
	}
}
