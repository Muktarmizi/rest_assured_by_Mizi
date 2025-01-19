package util;

import dto.Product;

public enum EnvKey
{
//	BASE_URL("base_url", "", 0),
//	DB_URL("db_url", "", 0),
//	DB_USER("db_user", "", 0),
//	DB_PASS("db_pass", "", 0);
	
	
//	String key;
//	String s;
//	int i;
	
//	EnvKey(String key, String s, int i)
//	{
//		this.key=key;
//		this.s=s;
//		this.i=i;
//	}
	
//	Product product = new Product(0,"", 0,"",new String[] {},"","",null);
	
	
	BASE_URL("base_url"),
	DB_URL("db_url"),
	DB_USER("db_user"),
	DB_PASS("db_pass");
	
	String key;
	
	private EnvKey(String key) 
	{
		this.key = key;
	}
	
	@Override
	public String toString() 
	{
		return key;
	}
	
	/**
	 * Get the original key
	 * @return {@link #key}
	 */
	public String getKey() 
	{
		return key;
	}
}
