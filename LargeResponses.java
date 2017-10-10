import java.io.*;
import java.util.Scanner;

public class LargeResponses {

    private static final String OUTPUT_FILE_PREFIX = "bytes_";
    private static final String FILE_EXT = ".txt";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        largeResponses(bufferedReader, filename);
    }

    private static void largeResponses(BufferedReader bufferedReader, String filename) {
        int numberOfLargeResponseRecords = 0;
        int totalSizeOfLargeResponse = 0;

        String record;
        try {
            while ((record = bufferedReader.readLine()) != null) {
                int bytes = Integer.valueOf(record.substring(record.lastIndexOf(" ") + 1));

                if (bytes > 5000) {
                    numberOfLargeResponseRecords++;
                    totalSizeOfLargeResponse += bytes;
                }
            }

            writeOutputToAFile(numberOfLargeResponseRecords, totalSizeOfLargeResponse, filename);
        } catch (IOException e) {
            // Logs The error
        }
    }

    private static void writeOutputToAFile(int numberOfLargeResponseRecords,
                                           int totalSizeOfLargeResponse,
                                           String filename) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_PREFIX + filename + FILE_EXT));
        bufferedWriter.write(String.valueOf(numberOfLargeResponseRecords));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(totalSizeOfLargeResponse));
        bufferedWriter.close();
    }
}
