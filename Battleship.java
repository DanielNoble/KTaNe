import java.util.ArrayList;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        System.out.println("Battleship");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter serial number: ");
        String serial = scanner.next();

        System.out.print("Enter num ports then num batteries + indicators: ");
        int last = scanner.nextInt();

        calc(serial, last);
    }

    public static void calc(String serial, int last) {
        String rval = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> cols = new ArrayList<String>();
        ArrayList<Integer> rows = new ArrayList<Integer>();
        // Calculate safe spaces with serial number
        for (int i = 0; i < serial.length(); i++) {
            String currentChar = serial.substring(i, i+1);
            if (currentChar.equals("0")) {
                currentChar = "5";
            }
            try {
                rows.add(Integer.parseInt(currentChar));
            } catch (NumberFormatException exc) {
                cols.add(currentChar);
            }
        }
        // Modulo letters in the columns arrayList
        for (int i = 0; i < cols.size(); i++) {
            int modCharPos = alphabet.indexOf(cols.get(i)) % 5;
            cols.set(i, alphabet.substring(modCharPos, modCharPos + 1));
        }
        // Modulo numbers in the rows arrayList
        for (int i = 0; i < rows.size(); i++) {
            rows.set(i, rows.get(i) % 5);
        }
        // Add modulo'd coordinates to rval
        while (cols.size() > 0 && rows.size() > 0) {
            if (rval.indexOf(cols.get(0) + "" + rows.get(0)) == -1) { // ensures unique new safe space
                rval += cols.remove(0) + rows.remove(0) + " ";
            }
        }


        // Calculate last safe space
        int mod5 = (last / 10 - 1) % 5;
        rval += "and " + alphabet.substring(mod5, mod5 + 1) + "" + (last % 5);

        System.out.println("Safe spaces are " + rval);
    }
}