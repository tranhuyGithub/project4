package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBContext{
	public static Connection getConnection() throws Exception{
		String url= "jdbc:sqlsever://" + severName + ":"+ portNumber + "\\" + instance + ";databaseName=" + dbName ;
		try {
			if(instance == null || instance.trim().isEmpty()) {
			 url = "jdbc:sqlserver://" + severName + ":"+ portNumber + ";databaseName=" + dbName ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					  
		 System.out.println("connect successfully!");
		return DriverManager.getConnection(url, userID, password);
	}
	public static void main(String args[]) {
        try {
          
			// connnect to database 'testdb'
            Connection conn = getConnection();
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            System.out.println("connect successfully!");
            ResultSet rs = stmt.executeQuery("select * from Products");
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
                        + "  " + rs.getString(3));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	private final static String severName ="localhost";
	private final static String dbName = "ShoppingDB";
	private final static String portNumber ="1433";
	private final static String instance = "";
	private final static String userID = "sa";
	private final static String password = "123456";
	
}