import java.util.Scanner;
   public class  PurchaseCalculator {
    public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);

     int counter = 1;
     int sum = 0;
     System.out.println("Welcome to E-Store");

      System.out.println("Enter customer Name: "); 
     String customerName = scanner.next();

      System.out.println("Enter number of item purchased: "); 
     int itemPurchased = scanner.next();

      System.out.println("Enter percentage discount: "); 
       int  percentage = scanner.next();


   

  while (counter <= 10) {

     System.out.print("please Enter cost for item :");
     int userInput = scanner.nextInt();

     sum += userInput;
         counter = counter + 1;
     }
    
  if(sum >= 200){
	double discount = (percentage / 100.0)*sum;    
     	double discountedCost = (sum - discount);
        
     	System.out.printf("Customer Name: %s%n itemPurchased: %d%n Original cost: %d%n Discounted cost: %.2f%nThanks for your patronage!", customerName,itemPurchased, sum, discountedCost);  
      }
  if(sum < 200){
    
     System.out.printf("Customer Name: %s%nOriginal cost: %d%nDiscounted cost: %s%nThanks for your patronage!", customerName, sum, "0(no discount added)"); 
     }
      
   }  
  }


