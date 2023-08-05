import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.println("Enter '1' to input text or '2' to provide a file: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.println("Enter the text:");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                inputText = readFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);

        // Additional features (e.g., ignoring common words, unique word count, word frequency, etc.)
        // You can add these features here.

        scanner.close();
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
