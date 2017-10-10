import java.util.Scanner;

public class FindTheWinner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfAndreaElements = scanner.nextInt();
        int[] andreaElements = new int[numberOfAndreaElements];
        for (int i = 0; i < numberOfAndreaElements; i++) {
            andreaElements[i] = scanner.nextInt();
        }

        int numberOfMariaElements = scanner.nextInt();
        int[] mariaElements = new int[numberOfMariaElements];
        for (int i = 0; i < numberOfMariaElements; i++) {
            mariaElements[i] = scanner.nextInt();
        }

        String gameStyle = scanner.next();

        findTheWinner(andreaElements, mariaElements, gameStyle);
    }

    private static void findTheWinner(int[] andreaElements,
                                      int[] mariaElements,
                                      String gameStyle) {
        String winner;
        if (gameStyle.equalsIgnoreCase("Even")) {
            winner = findTheWinnerInEvenGame(andreaElements, mariaElements);
            System.out.print(winner);
        }
        if (gameStyle.equalsIgnoreCase("Odd")) {
            winner = findTheWinnerInOddGame(andreaElements, mariaElements);
            System.out.print(winner);
        }
    }

    private static String findTheWinnerInEvenGame(int[] andreaElements,
                                                  int[] mariaElements) {
        int andreaScore = 0;
        int mariaScore = 0;
        for (int index = 0; index <= andreaElements.length; index = index + 2) {
            andreaScore += (andreaElements[index] - mariaElements[index]);
            mariaScore += (mariaElements[index] - andreaElements[index]);
        }
        return declareWinner(andreaScore, mariaScore);
    }

    private static String findTheWinnerInOddGame(int[] andreaElements,
                                                 int[] mariaElements) {
        int andreaScore = 0;
        int mariaScore = 0;
        for (int index = 1; index < andreaElements.length; index = index + 2) {
            andreaScore += (andreaElements[index] - mariaElements[index]);
            mariaScore += (mariaElements[index] - andreaElements[index]);
        }
        return declareWinner(andreaScore, mariaScore);
    }

    private static String declareWinner(int andreaScore, int mariaScore) {
        if (andreaScore > mariaScore) {
            return "Andrea";
        } else if (mariaScore > andreaScore) {
            return "Maria";
        } else {
            return "Tie";
        }
    }
}
