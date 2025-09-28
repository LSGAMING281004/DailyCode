package loginAccount;

import java.util.Scanner;

public class MainPage {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {

		LoginPage login = new LoginPage();
		SignUpPage signup = new SignUpPage();
		
		
		System.out.println("L-Company\n");
		System.out.print("1.Login\n2.SignUp\n3.Exit\n\nEnter the option:");
		int option = scanner.nextInt();
		switch(option) {
		case 1:
			login.getLoginInfo();
			break;
		case 2:
			signup.getSignUpInfo();
			break;
		default:
			System.out.println("Thank you");
		}
	}
}
