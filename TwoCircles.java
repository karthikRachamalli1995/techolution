import java.util.Scanner;

/**
 * Two Circles Test Drive
 */
public class TwoCircles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();

        String[] info = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            info[i] = scanner.nextLine();
        }

        String[] relationships = circles(info);

        for (String relationship : relationships) {
            System.out.println(relationship);
        }
    }

    static String[] circles(String[] info) {
        String[] relations = new String[info.length];
        for (int i = 0; i < info.length; i++) {
            String[] testcaseValues = info[i].split(" ");

            double x0 = Double.valueOf(testcaseValues[0]);
            double y0 = Double.valueOf(testcaseValues[1]);
            double r0 = Double.valueOf(testcaseValues[2]);
            double x1 = Double.valueOf(testcaseValues[3]);
            double y1 = Double.valueOf(testcaseValues[4]);
            double r1 = Double.valueOf(testcaseValues[5]);

            double distance = distanceBetweenTwoCircles(x0, y0, x1, y1);
            double radiusSum = radiusSum(r0, r1);
            double radiusSub = radiusSub(r0, r1);

            if (distance == radiusSum || distance == radiusSub) {
                relations[i] = "Touching";
                continue;
            }

            if (x0 == x1 && y0 == y1) {
                relations[i] = "Concentric";
                continue;
            }

            if (distance < radiusSum) {
                relations[i] = "Intersecting";
                continue;
            }

            if (distance > radiusSum) {
                relations[i] = "Disjoint-Outside";
                continue;
            }

            if (distance < radiusSub) {
                relations[i] = "Disjoint-Inside";
            }
        }
        return relations;
    }

    static double distanceBetweenTwoCircles(double x0, double y0, double x1, double y1) {
        // formula for distance between two circles d = sqrt(pow((x1-x0),2) + pow((y1-y0),2))
        return Math.hypot(x0 - x1, y0 - y1);
    }

    static double radiusSum(double r0, double r1) {
        return r0 + r1;
    }

    static double radiusSub(double r0, double r1) {
        return Math.abs(r0 - r1);
    }
}
