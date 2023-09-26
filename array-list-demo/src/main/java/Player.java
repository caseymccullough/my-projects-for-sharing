public class Player {

	// variables--should always be private
	
	private String myName;
	private String myPosition;
	private double myPPG;
	
	// methods -- generally public
	
	public Player (String name, String position, double ppg)
	// constructor
	{
		myName = name;
		myPosition = position;
		myPPG = ppg;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public String getPostion ()
	{
		return myPosition;
	}
	
	public double getPPG()
	{
		return myPPG;
	}
	
	public void setName(String name)
	{
		myName = name;
	}
	
	public void setPosition(String position)
	{
		myPosition = position;
	}
	
	public void setPPG (double ppg)
	{
		myPPG = ppg;
	}
	
	public String toString ()
	{
		return myName + ", postion: " + myPosition + " PPG: " + myPPG;
	}
	
	/*public boolean equals (Object other)
	{
	
		if (myName.equals ( ((Player)other.getName())) && 
		(myPosition.equals(((Player)other.getPostion())) && 
				(myPPG == ((Player) other.getPPG())))) 
			return true;
		else
			return false;
	}
	
	*/
	
}
