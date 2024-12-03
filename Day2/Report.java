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
        return (((allAscending(this.numbersInReport) || allDescending(this.numbersInReport)) && notGreaterThanThreeApart(this.numbersInReport)) || checkRemoved());
    }

    private boolean checkRemoved() {
        for (int i = 0; i < this.numbersInReport.size(); i++) {
            if (removeSpecificEntryAndValid(i)) {
                return true;
            }
        }

        return false;
    }

    private boolean removeSpecificEntryAndValid(int placeOfEntry) {
        ArrayList<Integer> returner = new ArrayList<>();

        for (int entry : this.numbersInReport) {
            returner.add(entry);
        }

        returner.remove(placeOfEntry);

        return ((allAscending(returner) || allDescending(returner)) && notGreaterThanThreeApart(returner));        
    }

    // Check if all numbers are ascending
    private boolean allAscending(ArrayList<Integer> toCheck) {
        for (int i = 0; i < toCheck.size() - 1; i++) {
            if (! (toCheck.get(i) < toCheck.get(i + 1))) {
                return false;
            }
        }

        return true;
    }

    // Check if all numbers are descending
    private boolean allDescending(ArrayList<Integer> toCheck) {
        for (int i = 0; i < toCheck.size() - 1; i++) {
            if (! (toCheck.get(i) > toCheck.get(i + 1))) {
                return false;
            }
        }

        return true;
    }

    // Check than none are >3 apart (Distance)
    private boolean notGreaterThanThreeApart(ArrayList<Integer> toCheck) {
        for (int i = 0; i < toCheck.size() - 1; i++) {
            if (Math.abs(toCheck.get(i) - toCheck.get(i + 1)) > 3) {
                return false;
            }
        }

        return true;
    }
}