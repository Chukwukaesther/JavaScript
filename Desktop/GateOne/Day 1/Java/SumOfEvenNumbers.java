import java.util.Scanner;
public class SumOfEvenNumbers {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

	
	int add = 0;
	int even = 0;

	for(int count = 0; count < 10; count++){
		System.out.print("Enter Score: ");
		int scores = input.nextInt();
		if(scores % 2 == 0){
		even = scores ;
		add = add + even; 
	}	
	}
	System.out.println("The sum of the even indexes is " + add);
      }
}