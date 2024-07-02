package Exercises;

public class Numbers {
    public static void main(String[] args) {


        int count = 0;
        int counter = 1;
        int sum = 0;

        for(count = 0; count < 11; count++) {
           counter = count + counter;
           sum = counter + counter;
            System.out.println(sum);

        }


    }
}


