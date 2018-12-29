import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WireSequences {
    public static ArrayList<String> red = new ArrayList<String>(Arrays.asList("c", "b", "a", "ac", "b", "ac", "abc", "ab", "b"));
    public static ArrayList<String> blue = new ArrayList<String>(Arrays.asList("b", "ac", "b", "a", "b", "bc", "c", "ac", "a"));;
    public static ArrayList<String> black = new ArrayList<String>(Arrays.asList("abc", "ac", "b", "ac", "b", "bc", "ab", "c", "c"));;
    public static void main(String[] args) {
        Scanner scan;
        String currentWire;
        for (int i = 0; i < 4; i++) {
            scan = new Scanner(System.in);
            while (scan.hasNext()) {
                currentWire = scan.next();
                if (currentWire.substring(0, 1).equals("r")) {
                    System.out.println(red.remove(0).indexOf(currentWire.substring(1, 2)) != -1);
                }
                else if (currentWire.substring(0, 1).equals("u")) {
                    System.out.println(blue.remove(0).indexOf(currentWire.substring(1, 2)) != -1);
                }
                else {
                    System.out.println(black.remove(0).indexOf(currentWire.substring(1, 2)) != -1);
                }
            }
        }
    }
}