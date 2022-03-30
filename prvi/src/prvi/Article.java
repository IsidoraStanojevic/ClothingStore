package prvi;

public class Article 
{
	public Article (String category, String name, String brand, float price, String size, String color) 
	{
		
		m_category = category;
		m_name= name;
		m_brand=brand;
		m_price= price;
		m_size=size;
		m_color= color;
	}
	
	public String getCategory() 
	{
		return m_category;
	}

	public String getName() 
	{
		return m_name;
	}

	public String getBrand() 
	{
		return m_brand;
	}

	public float getPrice() 
	{
		return m_price;
	}

	public String getSize() 
	{
		return m_size;
	}

	public String getColor() 
	{
		return m_color;
	}
	
	public float getDiscount() 
	{
		return m_discount;
	}
	
	public void setDiscount(int val)
	{
		m_discount = val;
	}
	
	private String m_category;
	private String m_name;
	private String m_brand;
	private float m_price;
	private String m_size;
	private String m_color;
	private int m_discount;
}
