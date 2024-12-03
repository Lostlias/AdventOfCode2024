package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Day1_Problem1 {
    
    public static void main(String[] args) {
        // File path
        String filePath = "input1.txt";
        int endSum = 0;
        int similarityScore = 0;

        // ArrayLists to store numbers
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        try {
            // Initialize Scanner for file reading
            Scanner scanner = new Scanner(new File(filePath));

            // Read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into numbers
                String[] parts = line.trim().split("\\s+"); // Splits by whitespace
                if (parts.length == 2) {
                    try {
                        // Parse numbers and add to respective lists
                        int firstNumber = Integer.parseInt(parts[0]);
                        int secondNumber = Integer.parseInt(parts[1]);

                        firstList.add(firstNumber);
                        secondList.add(secondNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in line: " + line);
                    }
                } else {
                    System.out.println("Invalid input line: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        for (int i = 0; i < firstList.size(); i++) {
            endSum += Math.abs(firstList.get(i) - secondList.get(i));
        }

        System.out.println("Your number is: " + endSum);

        for (int numberInFirst : firstList) {
            int count = 0;
            for (int numberInSecond : secondList) {
                if (numberInFirst == numberInSecond) {
                    count++;
                }
            }
            similarityScore += count * numberInFirst;
        }

        System.out.println("Your similarity score is: " + similarityScore);
    }

}