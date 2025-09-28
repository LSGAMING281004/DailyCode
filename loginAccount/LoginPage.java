package loginAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class LoginPage{

	Scanner scan = new Scanner(System.in);
	public void getLoginInfo() throws Exception {
		
		System.out.println("------ LOGIN ------\n");
		System.out.print("Enter Username:");
		String uname = scan.nextLine();
		System.out.print("Enter Password:");
		String password = scan.nextLine();
		
		if(checkAccount(uname,password)) {
			System.out.println("Login successfull");
		}else {
			System.out.println("Login faild invalid user Try again");
			getLoginInfo();
		}	
	}
	
	public boolean checkAccount(String uname,String pass) throws SQLException {
		
		String query = "select username, password from employeeaccounts;";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lcompany","root","lokesh281004");
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
		
			if(uname.equals(rs.getString(1)) && pass.equals(rs.getString(2))) {
				return true;
			}		
		}
		return false;
	}
}
