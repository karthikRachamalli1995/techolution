import java.util.Scanner;

public class ConsecutiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        System.out.print(numberOfWays(number));
    }

    private static int numberOfWays(long number) {
        int numberOfPossibleWays = 0;
        long temp, i, j;

        /*
            If the number is 1 then there will one solution that is 0+1
         */
        if (number == 1) {
            return 1;
        }

        /*
            Iterate upto n/2, after that if we add consecutive numbers then the sum will be
            greater than given number.
            n/2 + (n/2 + 1) is greater than n
        */
        int start = 0;
        long end = number / 2;
        for (i = start; i < end; i++) {
            /*
                Store number into a temp variable, By doing this there will be no
                effect on number of iterations from 0 to n/2
            */
            temp = number;
            j = i;
            /*
                Iterate till j is less than temp as we are incrementing the j and subtracting
                from temp i.e., number
             */
            while (j < temp) {
                temp = temp - j;
                j++;
            }
            /*
                If J equal to temp that means a possible sum of consecutive numbers are there
                that there sum results in given number
             */
            if (j == temp) {
                numberOfPossibleWays++;
            }
        }
        return numberOfPossibleWays;
    }
}

