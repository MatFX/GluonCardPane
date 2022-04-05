package eu.matfx;

public class GroupViewObject implements IVisible
{
	
	private int groupNumber;
	
	private String description;
	
	public GroupViewObject(int groupNumber, String description)
	{
		this.groupNumber = groupNumber;
		this.description = description;
	}
	
	public int getGroupNumber() {
		return groupNumber;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getDescriptionText() {
		return description + " " + groupNumber;
	}
	
	public String toString()
	{
		return description + " " + groupNumber;
	}


}
