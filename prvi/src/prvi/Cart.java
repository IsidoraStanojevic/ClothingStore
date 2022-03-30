package prvi;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	public Cart()
	{
		m_articles = new ArrayList<>();
	}
	
	public void PrintArticlesInCart() 
	{
		for (Article a : m_articles)
		{
			System.out.println(a.getName());
		}
		System.out.println("\n");
	}
	
	public void AddToCart(Article a)
	{
		m_articles.add(a);
	}
	
	List<Article> GetArticles()
	{
		return m_articles;
	}
	
	private List<Article> m_articles;
}
