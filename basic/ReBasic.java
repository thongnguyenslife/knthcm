package knthcm.basic;

import java.util.Scanner;

public class ReBasic {
    static Scanner sc = new Scanner(System.in);
    static String svHoTen;
    static int svTuoi = -1;
    static double svDiem = -1.0;
    static char svXepLoai;
    static boolean svTotNghiep;
    
    public static String inputSvHoTen(Scanner sc) {
        System.out.print("Ho ten: ");
        
        return sc.nextLine();
    }
    
    public static int inputSvTuoi(Scanner sc) {
        do {
            System.out.print("Tuoi: ");
            if (sc.hasNextInt()) {
                svTuoi = sc.nextInt();
                if (svTuoi <= 0) {
                    System.out.println("Vui long nhap so nguyen duong.");
                }
            } else {
                System.out.println("Vui long nhap so.");
                sc.next();
            }
        } while (svTuoi <= 0);
        
        return svTuoi;
    }
    
    public static double inputSvDiem(Scanner sc) {
        do {
            System.out.print("Diem TB: ");
            if (sc.hasNextDouble()) {
                svDiem = sc.nextDouble();
                if (svDiem < 0.0) {
                    System.out.println("Vui long nhap so duong hoac so 0.");
                }
            } else {
                System.out.println("Vui long nhap so.");
                sc.next();
            }
        } while (svDiem < 0.0);
        
        return svDiem;
    }
    
    public static char inputSvXepLoai(Scanner sc) {
        String input = "";
        sc.nextLine(); // fix loi \n
        
        do {
            System.out.print("Xep loai (A/B/C...): ");
            input = sc.nextLine();
            if (input.length() != 1 || !((input.charAt(0) >= 'a' && input.charAt(0) <= 'z') || (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z'))) {
                System.out.println("Vui long chi nhap 1 ky tu A/B/C...");
            } 
        } while (input.length() != 1 || !((input.charAt(0) >= 'a' && input.charAt(0) <= 'z') || (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z')));
        
        return svXepLoai = input.charAt(0);
    }
    
    public static String inputSvTotNghiep(Scanner sc) {      
        do {
            System.out.print("Tot nghiep (true/false): ");
            if (sc.hasNextBoolean()) {
                svTotNghiep = sc.nextBoolean();
                break;
            } else {
                System.out.println("Vui nhap chi nhap true hoac false.");
                sc.next();
            }
        } while (true);
        
        return svTotNghiep ? "Da xet" : "Chua xet";
    }
    
    public static void printSv(Scanner sc) {
        String input = inputSvTotNghiep(sc);
        
        System.out.println("\n=== THONG TIN SINH VIEN ===");
        System.out.printf("Ho ten: %s\n", svHoTen);
        System.out.printf("Tuoi: %d\n", svTuoi);
        System.out.printf("Diem TB: %.2f\n", svDiem);
        System.out.printf("Xep loai: %c\n", svXepLoai);
        System.out.printf("Tot nghiep: %s\n", input);
    }
    
    public static void main(String[] args) {
        // Nhap thong tin sinh vien
        svHoTen = inputSvHoTen(sc);
        svTuoi = inputSvTuoi(sc);
        svDiem = inputSvDiem(sc);
        svXepLoai = inputSvXepLoai(sc);
        
        // Xuat thong tin sinh vien ra man hinh
        printSv(sc);
    }
}
