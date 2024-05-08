import java.util.Scanner;
public class SumAndAverage {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

	
	int add = 0;
	int average = 0;
	for(int count = 0; count < 10; count++){
		System.out.print("Enter Score: ");
		int scores = input.nextInt();
		add = add + scores; 
		average = add / 10 ;
	}
	System.out.println("The sum of Scores is " + add);
	System.out.println("The average of Scores is " + average);
      }
}