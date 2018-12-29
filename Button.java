import java.util.Scanner;

public class Button {
    public static void main(String[] args) {
        System.out.println("The Button");
        int numBatteries = 0;
        boolean car = false;
        boolean frk = false;
        Scanner scan = new Scanner(System.in);
        String color = scan.next();
        String word = scan.next();
        if (word.equals("detonate")) {
            System.out.print("Num batteries: ");
            numBatteries = scan.nextInt();
        }
        if (color.equals("white")) {
            System.out.println("Lit indicator car: ");
            car = scan.nextBoolean();
        }
        if ((word.equals("detonate") && numBatteries >= 2) || (color.equals("red") && word.equals("hold"))) {
            System.out.println("press the button");
        }

        else if ((color.equals("red") && (word.equals("abort") || word.equals("press"))) || (color.equals("blue") && (word.equals("hold") || word.equals("press"))) || ((!car && color.equals("white") || color.equals("yellow")) && (word.equals("abort") || word.equals("hold") || word.equals("press")))) {
            System.out.print("Num batteries: ");
            numBatteries = scan.nextInt();
            if (numBatteries >= 3) {
                System.out.print("Lit indicator frk: ");
                frk = scan.nextBoolean();
                if (frk) {
                    System.out.println("press the button");
                } else {
                    hold();
                }
            } else {
                hold();
            }
        }

        else {
            hold();
        }
    }

    public static void hold() {
        System.out.println("Hold the button");
        Scanner scan = new Scanner(System.in);
        System.out.print("Strip color: ");
        String stripColor = scan.next();
        if (!stripColor.equals("")) {
            if (stripColor.equals("red") || stripColor.equals("white")) {
                System.out.println("1");
            }
            else if (stripColor.equals("blue")) {
                System.out.println("4");
            }
            else {
                System.out.println("5");
            }
        }
    }
}
