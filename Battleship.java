import java.util.ArrayList;
import java.util.Scanner;

public class Battleship {
    public static ArrayList<Integer> rows = new ArrayList<Integer>();
    public static ArrayList<Integer> cols = new ArrayList<Integer>();
    public static String fin = "Safe spaces are ";
    public static void main(String[] args) {
        System.out.println("Enter serial number then ports and batteries + indicators");
        Scanner scan = new Scanner(System.in);
        String serial = scan.next();
        int last = scan.nextInt();
        for (char current : serial.toCharArray()) {
            try {
                rows.add(Integer.parseInt(String.valueOf(current)));
            } catch (NumberFormatException exc) {
                cols.add(Character.getNumericValue(current));
            }
        }
        while (!rows.isEmpty() || !cols.isEmpty()) {
            calc(cols.remove(0), rows.remove(0));
        }
        calc(last / 10 - 1, last);
        System.out.println(fin);
    }

    public static void calc(int col, int row) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        col %= 5;
        row %= 5;
        if (row == 0)
            row += 5;
        if (col == 0)
            col += 5;
        String column = alphabet.substring(col, col + 1);
        if (fin.indexOf(column + row) == -1)
            fin += column + row + " ";
    }
}
