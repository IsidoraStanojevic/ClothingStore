package prvi;

import java.util.List;

public class Purchase {
	
	public Purchase(List<Article> articles)
	{
		m_articles_to_purchase = articles;
	}
	
	public void SetTwentyPrecentDiscountToAllArticles()
	{
		for (Article a : m_articles_to_purchase)
		{
			a.setDiscount(20);
		}
	}
	
	public void SetTuesdayDiscountToArticles()
	{
		int shirt_discount = 10;
		int shoe_discount = 25;
		
		for (Article a : m_articles_to_purchase)
		{
			if (a.getCategory().equals("Shirt") && a.getDiscount() < shirt_discount)
			{
				a.setDiscount(shirt_discount);
			}
			else if (a.getCategory().equals("Shoes") && a.getDiscount() < shoe_discount)
			{
				a.setDiscount(shoe_discount);
			}
		}
	}
	
	public void PopulateDiscountsForArticles(String dayName)
	{
		if (m_articles_to_purchase.size() >= 3)
		{
			SetTwentyPrecentDiscountToAllArticles();
		}
		
		if (dayName.equals("Tuesday"))
		{
			SetTuesdayDiscountToArticles();
		}
	}

	private List<Article> m_articles_to_purchase;
}
