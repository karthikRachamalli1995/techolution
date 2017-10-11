import java.util.Scanner;
import java.util.Stack;

public class BalancedOrNot {

    public static void main(String[] args) {
        //input length
        Scanner scanner = new Scanner(System.in);
        int numberOfExpressions = scanner.nextInt();

        /*
            Scanning expressions
         */
        String[] expressions = new String[numberOfExpressions];
        for (int i = 0; i < numberOfExpressions; i++) {
            expressions[i] = scanner.next();
        }

        /*
            Scanning maxReplacements
         */
        int maxReplacementsNumber = scanner.nextInt();
        int[] maxReplacements = new int[maxReplacementsNumber];
        for (int i = 0; i < numberOfExpressions; i++) {
            maxReplacements[i] = scanner.nextInt();
        }

        int[] result = balancedOrNot(expressions, maxReplacements);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] result = new int[expressions.length];
        String replaceValue = ">";
        int replacementCounter;
        for (int i = 0; i < expressions.length; i++) {
            replacementCounter = 0;
            String expression = expressions[i];
            int replacement = maxReplacements[i];
            result[i] = isBalancedOrNot(replacementCounter, expression, replaceValue, replacement);
        }
        return result;
    }

    static int isBalancedOrNot(int replacementCounter, String expression, String replaceValue, int replacement) {

        int openCount = 0;
        int closeCount = 0;
        String res;

        /*
            return 1 if expression is balanced
         */
        if (isBalanced(expression)) {
            return 1;
        }

        String[] brackets = expression.split("");
        for (String bracket : brackets) {
            if (replaceValue.equals(bracket)) {
                closeCount++;
            } else {
                openCount++;
            }
        }

        /*
            check if closeCount > openCount then we go for replacement
            if openCount > closeCount that expression can't be balanced
         */
        if (closeCount > openCount) {
            res = expression.replaceFirst(">", "<>");
            replacementCounter++;
            if (replacementCounter <= replacement) {
                return isBalancedOrNot(replacementCounter, res, replaceValue, replacement);
            }
        }
        /*
            return 0 if expression is not balanced after all the successive max replacements
         */
        return 0;
    }

    private static boolean isBalanced(String expression) {
        /*
            If length of the expression is odd return unbalanced
         */
        if ((expression.length() % 2) != 0) {
            return false;
        } else {
            /*
                If length of the expression is even we will push to stack to find whether it is balanced or not
             */
            String[] brackets = expression.split("");
            Stack<String> stack = new Stack<>();
            for (String bracket : brackets) {
                switch (bracket) {
                    case "<":
                        stack.push(">");
                        break;
                    default:
                        if (stack.empty() || !bracket.equalsIgnoreCase(stack.peek())) {
                            return false;
                        }
                        stack.pop();
                }
            }
            return stack.empty();
        }
    }
}

