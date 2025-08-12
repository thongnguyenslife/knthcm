package basic;

import java.util.Scanner;

public class DecimalToBinaryArrayRecursion {
    // Ham de quy de luu bit nhi phan vao mang
    public static int convertToBinary(long n, int[] bits, int index) {
        if (n < 2) { // Truong hop co so
            bits[index] = (int) n;
            return index + 1; // Tra ve so phan tu da luu
        }
        bits[index] = (int) (n % 2); // Luu phan du (LSB)
        return convertToBinary(n / 2, bits, index + 1); // De quy voi phan nguyen
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so sinh vien: ");
        String raw = sc.nextLine();

        // Loc bo ky tu khong phai chu so
        String digits = raw.replaceAll("\\D", "");
        if (digits.isEmpty()) {
            System.out.println("Khong co so hop le.");
            sc.close();
            return;
        }

        long n = Long.parseLong(digits);

        // Mang de chua bit (64 du cho long)
        int[] bits = new int[64];
        int length = convertToBinary(n, bits, 0);

        // In ra theo thu tu MSB -> LSB (nguoc lai vi luu tu LSB)
        System.out.print("Nhi phan (Mang + de quy): ");
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(bits[i]);
        }
        System.out.println();
        sc.close();
    }
}
