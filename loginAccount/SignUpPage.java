package loginAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SignUpPage{

	Scanner scan = new Scanner(System.in);
	public void getSignUpInfo() throws Exception {
		
		
		System.out.println("------ SiginUp ------\n");
		System.out.print("Enter Username:");
		String uname = scan.nextLine();
		System.out.print("Enter Password:");
		String password = scan.nextLine();
		System.out.print("Enter Confirm-Password:");
		String copassword = scan.nextLine();
		System.out.print("Enter Phone number:");
		long phNo = scan.nextLong();
		
		if(password.equals(copassword)) {
			if(signUpAccount(uname,password,phNo)) {
				System.out.println("Account Successflly Created");
			}else {
				System.out.println("Faild");
			}
		}else {
			System.out.println("Confirm password worng  Try again");
		}	
	}
	
	public boolean signUpAccount(String uname,String pass,long ph) throws SQLException {
		
		String query = "insert into employeeaccounts(username,password,ph) values('"+uname+"','"+pass+"',"+ph+");";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lcompany","root","lokesh281004");
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(query);
		con.close();
		stmt.close();
		
		return true;
	}
}
