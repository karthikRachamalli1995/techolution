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
        int memberGoingToServed = 0;

        int lengthOfQueue = memberTicketsCountArray.length;
        /*
            validating jessiePosition by checking whether it is more than size of the members in the queue
         */
        if (lengthOfQueue > jessiePosition) {
            /*
                Iterate up to jessie buys all her needed tickets i.e., memberTicketsCountArray[jessiePosition] != 0
             */
            while (memberTicketsCountArray[jessiePosition] != 0) {

                /*
                    If the counter reaches end of the queue initialise to "0", so that again serves from start
                 */
                if (memberGoingToServed == lengthOfQueue) {
                    memberGoingToServed = 0;
                }

                if (memberTicketsCountArray[memberGoingToServed] != 0) {
                    memberTicketsCountArray[memberGoingToServed] = memberTicketsCountArray[memberGoingToServed] - 1;
                    memberGoingToServed++;
                    waitingTimeForJessie++;
                } else {
                    memberGoingToServed++;
                }
            }
        }
        return waitingTimeForJessie;
    }
}
