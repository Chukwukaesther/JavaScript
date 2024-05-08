import java.util.Scanner;
public class AverageOfScore {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

	
	int add = 0;
	int average = 0;
	for(int count = 0; count < 10; count++){
		System.out.print("Enter Score: ");
		int scores = input.nextInt();
		add = add + scores;
		average = add / scores; 
	}
	System.out.print("The average of scores is " + average);
      }
}