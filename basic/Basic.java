import java.util.Scanner;

public class Basic {
    static String svHoTen;
    static int svTuoi;
    static double svDiem;
    static char svXepLoai;
    static boolean svTotNghiep;
    
    public static String inputsvHoTen(Scanner sc) {
        System.out.print("Ho ten: ");
        
        return sc.nextLine();
    }
    
    public static int inputsvTuoi(Scanner sc) {
        int input = -1;
        
        do {
            System.out.print("Tuoi: ");
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input <= 0) {
                    System.out.println("Vui long nhap so nguyen duong");
                }
            } else {
                System.out.println("Vui long nhap so nguyen");
                sc.next();
            }
        } while (input <= 0);
        
        return input;
    }
    
    public static double inputsvDiem(Scanner sc) {
        double input = -1.0;
         
        do {
            System.out.print("Diem TB: ");
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                if (input < 0) {
                    System.out.println("Vui long nhap so duong hoac so 0");
                }
            } else {
                System.out.println("Vui long nhap so");
                sc.next();
            }
        } while (input < 0);
    
        return input;
    }
    
    public static char inputsvXepLoai(Scanner sc) {
        String input = "";
        
        sc.nextLine(); // ← fix lỗi dư '\n'
        
        do {
            System.out.print("Xep loai (A/B/C...): ");
            if (sc.hasNextLine()) {
                input = sc.nextLine();
                if (input.length() != 1 || !((input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') || (input.charAt(0) >= 'a' && input.charAt(0) <= 'z'))) {
                    System.out.println("Vui long nhap 1 ky tu A/B/C...");
                }
            } else {
                System.out.println("Vui long nhap 1 ky tu A/B/C...");
                sc.next();
            }
        } while (input.length() != 1 || !((input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') || (input.charAt(0) >= 'a' && input.charAt(0) <= 'z')));
        
        return input.charAt(0);
    }
    
    public static boolean inputsvTotNghiep(Scanner sc) {
        boolean input;
        
        do {
            System.out.print("Tot nghiep (true/false): ");
            if (sc.hasNextBoolean()) {
                input = sc.nextBoolean();
                break;
            } else {
                System.out.print("Vui long chi nhap true hoac false. \n");
                sc.next();
            }
        } while (true);
    
        return input;
    }
    
    public static String convertsvTotNghieptoString(boolean svTotNghiep) {
        return svTotNghiep ? "Da xet" : "Chua xet";
    }

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        
        // Nhap thong tin sinh vien
        svHoTen = inputsvHoTen(sc);
        svTuoi = inputsvTuoi(sc);
        svDiem = inputsvDiem(sc);
        svXepLoai = inputsvXepLoai(sc);
        svTotNghiep = inputsvTotNghiep(sc);
        
        // Xuat thong tin sinh vien
        System.out.println("\n=== THONG TIN SINH VIEN ===");
        System.out.println("Ho ten: " + svHoTen);
        System.out.println("Tuoi: " + svTuoi);
        System.out.println("Diem TB: " + svDiem);
        System.out.println("Xep loai: " + svXepLoai);
        System.out.println("Tot nghiep: " + convertsvTotNghieptoString(svTotNghiep));
        
        sc.close();
    }
}
