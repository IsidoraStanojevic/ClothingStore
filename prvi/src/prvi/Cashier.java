package prvi;

public class Cashier {
	

	public void printRecipt(Cart cart, String dateTime)
	{
		System.out.println("Date: " + dateTime + "\n");
		System.out.println("---Products---");
		
		double subtotal = 0;
		double total = 0;
		for (Article a : cart.GetArticles())
		{
			subtotal+=a.getPrice();
			double reduced_price = Math.ceil( ((a.getPrice() * a.getDiscount()) / 100)*100.0 )/100.0;
			total = total + ((a.getPrice() - reduced_price));
			System.out.println(a.getName() + " - " + a.getBrand());
			System.out.println("$" + a.getPrice());
			System.out.println("#discount "+ a.getDiscount() + "%" + " -" + "$" + reduced_price + "\n");
		}		
		System.out.println("-----------------------------------------------------------------------------------\n");
		System.out.printf("SUBTOTAL: $%.2f\n", subtotal);
		System.out.printf("SUBTOTAL: $%.2f\n", (total-subtotal));
		System.out.printf("TOTAL: $%.2f\n", total);
	}
	
}
