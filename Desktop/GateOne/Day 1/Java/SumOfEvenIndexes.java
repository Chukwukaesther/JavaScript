import java.util.Scanner;
public class SumOfEvenIndexes {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

	
	int add = 0;
	int even = 0;

	for(int count = 0; count < 10; count++){
		System.out.print("Enter Score: ");
		int scores = input.nextInt();
		if(count % 2 == 0){
		even = count ;
		add = add + count; 
	}	
	}
	System.out.println("The sum of the even indexes is " + add);
      }
}