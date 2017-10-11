import java.util.Scanner;

public class InTheFuture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ashaProblemsPerDay = scanner.nextInt();
        int kellyProblemsPerDay = scanner.nextInt();
        int numberOfProblemsAshaAheadOfKelly = scanner.nextInt();

        int minimumNumberOfDays = minNum(
                ashaProblemsPerDay,
                kellyProblemsPerDay,
                numberOfProblemsAshaAheadOfKelly
        );
        System.out.print(minimumNumberOfDays);
    }

    private static int minNum(int ashaProblemsPerDay,
                              int kellyProblemsPerDay,
                              int numberOfProblemsAshaAheadOfKelly) {
        /*
            Checking the conditions if the conditions doesn't meet return -1
         */
        if (isInValidateInput(ashaProblemsPerDay, kellyProblemsPerDay, numberOfProblemsAshaAheadOfKelly)) {
            return -1;
        }

        /*
            Checking number of problems solving per day by Asha is greater than or equal to number of
            problems solved by Kelly,if it is the case its impossible to kelly to suppress Asha;
         */
        if (ashaProblemsPerDay >= kellyProblemsPerDay) {
            return -1;
        }

        /*
         Initialising number of days to 1 because minimum number of days to suppress is 1
         */
        int numberOfDays = 1;

        /*
        Initialising totalNumberOfProblemsOfAshaPerDay to asha per day problem rate + number of problems
        Asha ahead of kelly as on first day.
        And totalNumberOfProblemsOfKellyPerDay to kellyProblemsPerDay, As kelly doesn't have any ahead
        problems.
         */
        int totalNumberOfProblemsOfAshaPerDay = ashaProblemsPerDay + numberOfProblemsAshaAheadOfKelly;
        int totalNumberOfProblemsOfKellyPerDay = kellyProblemsPerDay;


        /*
            Iterate the loop until totalNumberOfProblemsOfKellyPerDay less than totalNumberOfProblemsOfAshaPerDay
            as then only kelly beats asha
         */
        while (totalNumberOfProblemsOfKellyPerDay <= totalNumberOfProblemsOfAshaPerDay) {
            totalNumberOfProblemsOfAshaPerDay += ashaProblemsPerDay;
            totalNumberOfProblemsOfKellyPerDay += kellyProblemsPerDay;
            numberOfDays++;
        }

        return numberOfDays;
    }

    private static boolean isInValidateInput(int ashaProblemsPerDay,
                                             int kellyProblemsPerDay,
                                             int numberOfProblemsAshaAheadOfKelly) {
        /*
           Checking below conditions if they are passed that means its a validate input
            1 <= Asha,Kelly <= 100
            0 <= problemsAhead <= 100
         */
        if ((1 <= ashaProblemsPerDay && ashaProblemsPerDay <= 100) &&
                (1 <= kellyProblemsPerDay && kellyProblemsPerDay <= 100) &&
                (0 <= numberOfProblemsAshaAheadOfKelly && numberOfProblemsAshaAheadOfKelly <= 100)) {
            return false;
        }
        return true;
    }
}
