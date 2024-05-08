import java.util.Scanner;
public class AverageOfEven {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

	
	int add = 0;
	int even = 0;
	int average = 0;

	for(int count = 0; count < 10; count++){
		System.out.print("Enter Score: ");
		int scores = input.nextInt();
		if(scores % 2 == 0){
		even = scores ; 
		add = add + even;
		average = add / count;
	
	}	
	}
	System.out.println("The average of the evenNumbers is " + average);
      }
}