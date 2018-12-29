import java.util.Scanner;

public class Memory {

    public static int[] vals = new int[5];
    public static int[] posits = new int[5];

    public static void main(String[] args) {
        System.out.println("Memory");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Phase 1: ");
        one(scanner.next());
        System.out.println(vals[0]);

        System.out.print("Phase 2: ");
        two(scanner.next());
        System.out.println(vals[1]);

        System.out.print("Phase 3: ");
        three(scanner.next());
        System.out.println(vals[2]);

        System.out.print("Phase 4: ");
        four(scanner.next());
        System.out.println(vals[3]);

        System.out.print("Phase 5: ");
        five(scanner.next());
        System.out.println(vals[4]);
    }

    public static void one(String input) {
        int bigNum = Integer.parseInt(input.substring(4, 5));
        if (bigNum == 1 || bigNum == 2) {
            pos(1, 2, input);
        }
        else if (bigNum == 3) {
            pos(1, 3, input);
        }
        else {
            pos(1, 4, input);
        }
    }

    public static void two(String input) {
        int bigNum = Integer.parseInt(input.substring(4, 5));
        if (bigNum == 1) {
            val(2, 4, input);
        }
        else if (bigNum == 2 || bigNum == 4) {
            samePosAs(2, 1, input);
        }
        else {
            pos(2, 1, input);
        }
    }

    public static void three(String input) {
        int bigNum = Integer.parseInt(input.substring(4, 5));
        if (bigNum == 1) {
            sameValAs(3, 2, input);
        }
        else if (bigNum == 2) {
            sameValAs(3, 1, input);
        }
        else if (bigNum == 3) {
            pos(3, 3, input);
        }
        else {
            val(3, 4, input);
        }
    }

    public static void four(String input) {
        int bigNum = Integer.parseInt(input.substring(4, 5));
        if (bigNum == 1) {
            samePosAs(4, 1, input);
        }
        else if (bigNum == 2) {
            pos(4, 1, input);
        }
        else {
            samePosAs(4, 2, input);
        }
    }

    public static void five(String input) {
        int bigNum = Integer.parseInt(input.substring(4, 5));
        if (bigNum == 1) {
            sameValAs(5, 1, input);
        }
        else if (bigNum == 2) {
            sameValAs(5, 2, input);
        }
        else if (bigNum == 3) {
            sameValAs(5, 4, input);
        }
        else {
            sameValAs(5, 3, input);
        }
    }

    public static void sameValAs(int current, int target, String currentInput) {
        vals[current - 1] = vals[target - 1];
        posits[current - 1] = currentInput.indexOf(vals[current - 1]) + 1;
    }

    public static void samePosAs(int current, int target, String currentInput) {
        vals[current - 1] = Integer.parseInt(currentInput.substring(posits[target - 1] - 1, posits[target - 1]));
        posits[current - 1] = posits[target - 1];
    }

    public static void val(int stage, int val, String currentInput) {
        vals[stage - 1] = val;
        posits[stage - 1] = currentInput.indexOf(val) + 1;
    }

    public static void pos(int stage, int pos, String currentInput) {
        vals[stage - 1] = Integer.parseInt(currentInput.substring(pos - 1, pos));
        posits[stage - 1] = pos;
    }
}