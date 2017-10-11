import java.util.Scanner;

public class ConsecutiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        System.out.print(consecutive(number));
    }

    static int consecutive(long number) {
        int numberOfPossibleWays = 0;
        /*
            If the number is 1 then there will one solution that is 0+1
         */
        if (number == 1) {
            return 1;
        }

        /*
            Iterate upto n+1/2, after that if we add consecutive numbers then the sum will be
            greater than given number.
            n/2 + (n/2 + 1) is greater than n
        */

        long endNumber = (number + 1) / 2;
        for (long start = 1; start < endNumber; start++) {

            long sumOfConsecutiveNumbers = 0;
            for (long i = start; i <= endNumber; i++) {

                sumOfConsecutiveNumbers += i;

                /*
                 if sumOfConsecutiveNumbers is equal to number that means a consecutive sequence update number of possible ways
                 */
                if (sumOfConsecutiveNumbers == number) {
                    numberOfPossibleWays++;
                    break;
                }

                /*
                 if sumOfConsecutiveNumbers is greater than number that means we can't get the consecutive sequence
                 */
                if (sumOfConsecutiveNumbers > number)
                    break;
            }
        }
        return numberOfPossibleWays;
    }
}

