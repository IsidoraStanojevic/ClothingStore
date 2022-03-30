package prvi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class main {
	
	static boolean IsCategoryValid(String input)
	{
		if (input.equals("Shirt") || input.equals("Shoes") || input.equals("Jacket") || input.equals("Trousers"))
		{
			return true;
		}
			
		return false;
	}
	
	static boolean IsSizeValid(String category, String input)
	{
		int numeric_value;
		
		switch (category)
		{
		case "Shirt":
			if (!input.equals("XS") && !input.equals("S") && !input.equals("M") && !input.equals("L") && 
					!input.equals("XL") && !input.equals("2XL"))
					return false;
			break;
			
		case "Shoes":
			numeric_value = Integer.parseInt(input);
			if (numeric_value < 39 || numeric_value > 46)
				return false;
			break;
			
		case "Jacket":
		case "Trouser":
			numeric_value = Integer.parseInt(input);
			if (numeric_value < 42 || numeric_value > 66 || numeric_value % 2 != 0)
				return false;
			break;
		}
		return true;
	}
	
	
 public static void main(String[] args){
	 
	Article article;
	Cart cart = new Cart();
	
	 
	try {
		//TODO unos fajla?
		FileInputStream fis = new FileInputStream("ListOfInputs.txt");
		Scanner s = new Scanner (fis);	
		while (s.hasNextLine()){
			String category = s.nextLine();
			if (!IsCategoryValid(category))
			{
				System.out.println("Invalid category name: " + category);
			}
			String name = s.nextLine();
			String brand = s.nextLine();
			float price = Float.parseFloat(s.nextLine());
			String size = s.nextLine();
			if (!IsSizeValid(category, size))
			{
				System.out.println("Invalid size: " + size + " for cateogry: " + category);
			}
			String color = s.nextLine();
			article = new Article(category, name, brand, price, size, color);
			cart.AddToCart(article);
				
		}
		
		//cart.PrintArticlesInCart();
		
		Purchase purchase = new Purchase(cart.GetArticles());
		
		// Date format for day name.
		DateFormat dateFormat = new SimpleDateFormat("EEEE");
		Date date = new Date();
		
		// Active date
		purchase.PopulateDiscountsForArticles(dateFormat.format(date));
		
		//Tuesday test
		//purchase.PopulateDiscountsForArticles("Tuesday");
		
		// Format for full date.
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Cashier cashier = new Cashier();
		cashier.printRecipt(cart, dateFormat.format(date));
		
		s.close();
		fis.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 
	
			 
	 
 } 	 
}
