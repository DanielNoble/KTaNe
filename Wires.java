import java.util.Scanner;

public class Wires {
    public static String serial;
    public static int redCount;
    public static int blueCount;
    public static int yellowCount;
    public static int whiteCount;
    public static int blackCount;
    public static boolean serialOdd;

    public static void main(String[] args) {
        System.out.println("Simple Wires");
        Scanner scan = new Scanner(System.in);
        System.out.println("Black is \"a\" and Blue is \"u\"");
        System.out.print("Input Serial #: ");
        serial = scan.next();
        System.out.print("Input Wires: ");
        String sequence = scan.next();
        int length = sequence.length();
            // Determining the count of colors of wires
            for (int i = 0; i < length; i++) {
                String currentChar = sequence.substring(i, i+1);
                if (currentChar.equals("r"))
                    redCount++;
                else if (currentChar.equals("u"))
                    blueCount++;
                else if (currentChar.equals("y"))
                    yellowCount++;
                else if (currentChar.equals("w"))
                    whiteCount++;
                else if (currentChar.equals("a"))
                    blackCount++;
            }
            // Determining serialOdd
            if (Integer.parseInt(serial.substring(serial.length() - 1, serial.length())) % 2 == 1)
                serialOdd = true;
            else
                serialOdd = false;
        if (length == 3) {
            System.out.println(three(sequence));
        }
        else if (length == 4) {
            System.out.println(four(sequence));
        }
        else if (length == 5) {
            System.out.println(five(sequence));
        }
        else
            System.out.println(six(sequence));
    }

    public static String three(String input) {
        if (input.indexOf("r") == -1) {
            return "2";
        }
        else if (input.substring(2, 3).equals("w")) {
            return "3";
        }
        else {
            int blueCount = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.substring(i, i+1).equals("u"))
                    blueCount++;
            }
            if (blueCount >= 2)
                return "Second blue";
            else
                return "3";
        }
    }

    public static String four(String input) {

        if (redCount > 1 && serialOdd)
            return "Last red";
        else if ((input.substring(input.length() - 1, input.length()).equals("y") && redCount == 0) || blueCount == 1)
            return "1";
        else if (yellowCount > 1)
            return "4";
        else
            return "2";
    }

    public static String five(String input) {
        if (input.substring(input.length() - 1, input.length()).equals("a") && serialOdd)
            return "4";
        else if (redCount == 1 && yellowCount > 1)
            return "1";
        else if (blackCount == 0)
            return "2";
        else
            return "1";
    }

    public static String six(String input) {
        if (yellowCount == 0 && serialOdd)
            return "3";
        else if (yellowCount == 1 && whiteCount > 1)
            return "4";
        else if (redCount == 0)
            return "6";
        else
            return "4";
    }
}
