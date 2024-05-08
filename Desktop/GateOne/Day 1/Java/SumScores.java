import java.util.Scanner;
public class Sum {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

	
	int add = 0;
	

	for(int count = 0; count < 100; count++){
		System.out.print("Enter Score: ");
		int scores = input.nextInt();
		
		add = add + scores;
		
	
	}	
	}
	System.out.println("The sum of the scores is " + add);
      
      }
}