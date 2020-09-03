package ATM;
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
public class Atm 
{
	static Map<String,String> map=new LinkedHashMap<>();
	static String accountID="";
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to ABC Bank. Happy to service you\n");
		OUTER1:while(true)
		{
		System.out.println("Enter your choice:  A) ADMIN   B) CUSTOMER");
		char choice=sc.next().charAt(0);
		Bank bank=new Bank();
		switch(choice)
		{
		case 'A':
			OUTER:while(true)
			{
			    System.out.println("Enter your User ID :");
			    String userId=sc.next();
			    System.out.println("Enter your Password :");
			    String password=sc.next();
			    if(bank.adminDetails(userId,password))
			    {
				    System.out.println("Access Granted....");
				    System.out.println("Enter your Choice: 1) Money Refund  2) Check Performance");
				    int n=sc.nextInt();
				    switch(n)
				    {
				    case 1:
				    	System.out.println("Enter the amount to be refunded :");
				    	float refundingAmount=sc.nextFloat();
				    	Machine machine=new Machine(refundingAmount);
				    	System.out.println("Amount refunded Successfully !!!");
				    	System.out.print("Balance Amount is RS."+machine.balance());
				    	break;
				    case 2:
				    	System.out.println("\nWelcome to the Performance catalogue.");
				    	System.out.println("The past Transactions done in this machine are");
				    	transactionHistory();
				    	System.out.print("Do you want to reset the Transaction History (Y/N)");
				    	char choice1=sc.next().charAt(0);
				    	if(choice1=='Y')
				    		map.clear();
				    	else
				    		System.out.println("Thankyou !!!");
				    	break;
				    }
				    break OUTER;
			    }
			    else
			    {
			    	System.out.println("\nYour ID and Password is Wrong");
			    	System.out.println("Enter Valid Credentials !!!\n");
			    	continue OUTER;
			    }
			}
		break;
		case 'B':
			INNER:while(true)
			{
			    System.out.println("Welcome User !!!");
			    System.out.println("Enter User ID");
			    String customerID=sc.next();
			    System.out.println("Enter Password");
			    String Password=sc.next();
			    Machine machine1=new Machine();
			    if(bank.userDetails(customerID,Password))
			    {
			    	System.out.println("Login Successful");
			    	System.out.print("Enter your account ID :");
					accountID=sc.next();
					OUTER2:while(true)
					{
					System.out.print("Enter your 4 digit Password :");
					int Pin=sc.nextInt();
					if(bank.pinValidate(Pin))
					{
						showMenu(machine1,sc,accountID);
					}
					else
					{
						System.out.println("Invalid PIN... Please Enter correctly");
						continue OUTER2;
					}
					}
			    }
			    else
			    {
			    	System.out.println("\nYour ID and Password is Wrong");
			    	System.out.println("Enter Valid Credentials !!!\n");
			    	continue INNER;
			    }
			}
		default: 
			System.out.println("Enter valid option... ");
			continue OUTER1;
		}
		}
	}
	private static void showMenu(Machine machine,Scanner sc,String accountID)
	{
		OUTER4:while(true)
		{
		    System.out.println("Choose Your Option: ");
		    System.out.println("\n1) Amount Deposit ");
		    System.out.println("2) Amount Withdraw");
		    System.out.println("3) Check Balance");
		    System.out.println("4) Print Transaction Receipt");
		    System.out.println("5) Exit");
		    int option=sc.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("Enter the amount to be deposited :");
				float depositingAmount=sc.nextFloat();
				machine.deposit(depositingAmount);
				map.put(accountID,machine.balance());
				break;
				
			case 2:
				System.out.println("Enter the amount to be withdrawn :");
				float withdrawingAmount=sc.nextFloat();
				machine.withdraw(withdrawingAmount);
				map.put(accountID,machine.balance());
				break;
				
			case 3:
				System.out.println("Your Account Balance is :"+machine.balance());
				break;
				
			case 4:
				System.out.println("Your Transaction Details :");
				transactionHistory();
				break;
				
			case 5:
				System.exit(0);
	
				default:
				{
					System.out.println("Please Enter a Valid Option !!!.");
					continue OUTER4;
				}
				
			}
		}
	}
	static void transactionHistory()
	{
		System.out.println("Account ID        Amount");
		for(Map.Entry<String,String> m:map.entrySet()) 
		{
			System.out.print(m.getKey()+"     "+m.getValue());
		}
		System.out.println("\n");
	}
}
