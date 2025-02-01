import java.io.*;
import java.util.*;

class Task9 {
    private static final List<String> keywords = Arrays.asList("ERROR", "WARNING");

    public static void analyzeLogFile(String inputFile, String outputFile) {
        Map<String, Integer> keywordCounts = new HashMap<>();

        for (String keyword : keywords) {
            keywordCounts.put(keyword, 0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        keywordCounts.put(keyword, keywordCounts.get(keyword) + 1);
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }

            writer.newLine();
            writer.write("Log Analysis Summary:");
            writer.newLine();
            for (Map.Entry<String, Integer> entry : keywordCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }

            System.out.println("Log analysis completed. Check output file: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input log file path: ");
        String inputFile = sc.nextLine();

        System.out.print("Enter output file path: ");
        String outputFile = sc.nextLine();

        analyzeLogFile(inputFile, outputFile);
        sc.close();
    }
}
