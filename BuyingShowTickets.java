import java.util.Scanner;

public class BuyingShowTickets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
            Scanning number of tickets per member
         */
        int numberOfMembers = scanner.nextInt();
        int[] memberTicketsCountArray = new int[numberOfMembers];
        for (int i = 0; i < numberOfMembers; i++) {
            int numberOfTickets = scanner.nextInt();
            memberTicketsCountArray[i] = numberOfTickets;
        }

        /*
            Scanning position of member that we need to calculate the time
            note: this position is index of the memberTicketsCountArray where exactly jessie stands
         */
        int position = scanner.nextInt();

        /*
            total time for jessie to buy tickets all her desired number of tickets
         */
        long waitingTime = waitingTime(memberTicketsCountArray, position);

        System.out.println(waitingTime);
    }

    static long waitingTime(int[] memberTicketsCountArray, int jessiePosition) {
        long waitingTimeForJessie = 0;
        int memberToBeServed = 0;
        /*
            initialise the differenceTicketsCounterArray with respect to jessie tickets so that we can reduce the number
            of comparisons
         */
        int[] differenceTicketsCounterArray = new int[memberTicketsCountArray.length];
        int i = 0;
        while (i < memberTicketsCountArray.length) {
            differenceTicketsCounterArray[i] = memberTicketsCountArray[i] - memberTicketsCountArray[jessiePosition];
            i++;
        }

        while (memberToBeServed < memberTicketsCountArray.length) {
            /*
                If the difference between the number of tickets of a member to be served is less than tickets of jessie,
                then obviously jessie will wait until those tickets are served.
             */
            if (differenceTicketsCounterArray[memberToBeServed] < 0) {
                waitingTimeForJessie += memberTicketsCountArray[memberToBeServed];
            } else {
                /*
                    If the difference between the number of tickets of a member to be served is greater than tickets of jessie,
                    then we will see two cases
                    1) member to be served is ahead of jessie in queue
                    2) member to be served is before of jessie in queue
                 */
                if (memberToBeServed > jessiePosition) {
                   /*
                        if member to be served is ahead of jessie in queue then simply we will serve the jessie
                        by one ticket and continue the serving process
                    */
                    waitingTimeForJessie += memberTicketsCountArray[jessiePosition] - 1;
                } else {
                   /*
                        if member to be served is before of jessie in queue then waiting time will incremented with
                        the tickets needed by jessie it self
                    */
                    waitingTimeForJessie += memberTicketsCountArray[jessiePosition];
                }
            }
            memberToBeServed++;
        }
        return waitingTimeForJessie;
    }
}
