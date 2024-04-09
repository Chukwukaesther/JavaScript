import java.util.Scanner;
   	public class ProductPrice{
  	public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter price: ");
  		double price = scanner.nextInt();

	System.out.print("Enter discount: ");
		double discount = scanner.nextInt();
	double newPrice = price -(discount * 0.01 * price);
		System.out.print("The new price is %d" + newPrice);


        }
     }

