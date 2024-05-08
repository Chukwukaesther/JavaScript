import java.util.Arrays;
import java.util.Scanner;
public class TaskOne{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);


	int[] scores = new int[10];


	
	for(int count = 0; count < scores.length; count++){
		System.out.print("Enter Score: ");
		int score = input.nextInt();
		scores[count] = score;
	      
		
	
	}
	System.out.print(Arrays.toString(scores));

	}
}