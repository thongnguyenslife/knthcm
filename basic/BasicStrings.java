
import java.util.Scanner;

public class BasicStrings {
    static Scanner sc = new Scanner(System.in);
    static String myString = "";

    public static String inputmyString(Scanner sc) {
        System.out.print("Nhap chuoi ky tu: ");
        return sc.nextLine();
    }

    public static void printChar(String s) {
        System.out.println("In tung ky tu:");
        for (int i = 0; i < s.length(); i++) {
            System.out.printf(" %c  ", s.charAt(i));
        }
    }

    public static void main(String[] args) {
        // Nhap chuoi ky tu
        myString = inputmyString(sc);

        // Xuat chuoi ky tu
        System.out.println("\n=== THONG TIN TRICH XUAT ===");
        System.out.println("Chuoi ban nhap: " + myString);
        printChar(myString);
    }
}
