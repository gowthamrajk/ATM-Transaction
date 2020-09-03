package ATM;
public class Bank 
{
	private String AdminId="SBIPOY3040";
	private String AdminPassword="SBIPOY@1234";
	private String userID="USER001";
	private String userPassword="user@123";
	
	public boolean adminDetails(String userId,String Password)
	{
		if(userId.equals(AdminId)&&Password.equals(AdminPassword))
			return true;
		else
			return false;
	}
	
	public boolean userDetails(String customerID, String Password) 
	{
		if(customerID.equals(userID)&&Password.equals(userPassword))
			return true;
		else
			return false;
	}

	public boolean pinValidate(int pin)
	{
		if(pin==2000)
			return true;
		else
		    return false;
	}
	
}
