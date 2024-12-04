package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static void main(String[] args) {
        // File path to the input text file
        String filePath = "input3.txt";
        File inputFile = new File(filePath);

        // Regex patterns for instructions. Changed to one pattern to be able to handle subsequent OPs
        String instructionPattern = "(mul\\((?<X>\\d+),(?<Y>\\d+)\\)|do\\(\\)|don't\\(\\))"; // Matches mul(X, Y), do(), or don't()

        // Compile the pattern
        Pattern instructionRegex = Pattern.compile(instructionPattern);

        // Initialize state
        boolean flag = true; // Multiplication enabled by default
        int total = 0;

        try (Scanner scanner = new Scanner(inputFile)) { // Auto-closing scanner
            StringBuilder memory = new StringBuilder();

            // Read the entire file content into memory (one string)
            while (scanner.hasNextLine()) {
                memory.append(scanner.nextLine());
            }

            // Corrupted memory string
            String memoryContent = memory.toString();

            // Parse the memory string sequentially
            Matcher instructionMatcher = instructionRegex.matcher(memoryContent);

            // Process all instructions in sequence
            while (instructionMatcher.find()) {
                String instruction = instructionMatcher.group(); // Full matched instruction

                if (instruction.equals("do()")) {
                    // Enable multiplication
                    flag = true;
                } else if (instruction.equals("don't()")) {
                    // Disable multiplication
                    flag = false;
                } else if (instruction.startsWith("mul")) {
                    // Process mul(X, Y) if flag is enabled
                    if (flag) {
                        int x = Integer.parseInt(instructionMatcher.group("X"));
                        int y = Integer.parseInt(instructionMatcher.group("Y"));
                        total += x * y;
                    }
                }
            }

            // Print the result
            System.out.println("Total: " + total);

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filePath);
            e.printStackTrace();
        }
    }
}
