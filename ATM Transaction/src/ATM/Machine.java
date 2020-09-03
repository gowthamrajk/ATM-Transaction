package ATM;
public class Machine
{
	private float refundingAmount=0;
	private float balanceAmount=0;
	Machine(){
		
	}
	Machine(float refundingAmount)
	{
		this.refundingAmount=refundingAmount;
		this.balanceAmount=balanceAmount+refundingAmount;
	}	
	String balance()
	{
		return ""+balanceAmount;
	}
	public void withdraw(float withdrawingAmount) 
	{
		balanceAmount-=withdrawingAmount;		
	}
	public void deposit(float depositingAmount)
	{
		balanceAmount+=depositingAmount;			
	}
	
}
