package Day2;

import java.util.ArrayList;

public class Report {
    private String[] parts;
    private ArrayList<Integer> numbersInReport = new ArrayList<>();

    public Report(String numbers) {
        this.parts = numbers.trim().split("\\s+");
        
        for (String part : parts) {
            numbersInReport.add(Integer.parseInt(part));
        }
    }

    public boolean checkReport() {
        return ((allAscending() || allDescending()) && notGreaterThanThreeApart());
    }

    // Check if all numbers are ascending
    private boolean allAscending() {
        for (int i = 0; i < this.numbersInReport.size() - 1; i++) {
            if (! (this.numbersInReport.get(i) < this.numbersInReport.get(i + 1))) {
                return false;
            }
        }

        return true;
    }

    // Check if all numbers are descending
    private boolean allDescending() {
        for (int i = 0; i < this.numbersInReport.size() - 1; i++) {
            if (! (this.numbersInReport.get(i) > this.numbersInReport.get(i + 1))) {
                return false;
            }
        }

        return true;
    }

    // Check than none are >3 apart (Distance)
    private boolean notGreaterThanThreeApart() {
        for (int i = 0; i < this.numbersInReport.size() - 1; i++) {
            if (Math.abs(this.numbersInReport.get(i) - this.numbersInReport.get(i + 1)) > 3) {
                return false;
            }
        }

        return true;
    }
}