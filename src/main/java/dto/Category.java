package dto;

public class Category 
{
	private int id;
	private String name;
	private String image;
	private String creationAt;
	private String updatedAt;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getImage() 
	{
		return image;
	}
	
	public void setImage(String image) 
	{
		this.image = image;
	}
	
	public String getCreationAt() 
	{
		return creationAt;
	}
	
	public void setCreationAt(String creationAt) 
	{
		this.creationAt = creationAt;
	}
	
	public String getUpdatedAt() 
	{
		return updatedAt;
	}
	
	public void setUpdatedAt(String updatedAt) 
	{
		this.updatedAt = updatedAt;
	}
}
