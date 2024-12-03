package Day2;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {

    public static void main(String[] args) {
        // File Path
        String filePath = "input2.txt";

        ArrayList<String> reports = new ArrayList<>();

        int safeReports = 0;


        try {
            // Initialize Scanner
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNextLine()) {
                reports.add(scanner.nextLine());    
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

        for (String entry : reports) {
            Report current = new Report(entry);
            if (current.checkReport()) {
                safeReports++;
            }
        }

        System.out.println("Number of safe reports: " + safeReports);
    }
}

