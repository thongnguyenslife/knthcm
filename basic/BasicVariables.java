import java.util.Scanner; // Thu vien nhap du lieu
// import java.util.*; Khai bao tat ca cac lop tu goi java.util

public class BasicVariables {
    public static void main(String[] args) {
        // Khoi tao doi tuong nhap du lieu
        Scanner sc = new Scanner(System.in);
        
        /*
        String studentName;
        int studentAge = -1;
        double studentGPA = 1.0; // float thi them f
        char studentLevel = ' '; // A, B, C..., char thi '', String thi ""
        boolean studentStatus;
        
        // Nhap du lieu
        System.out.print("Ho ten: ");
        studentName = sc.nextLine();
        
        do {
            System.out.print("Tuoi: ");
            if (sc.hasNextInt()) {
                studentAge = sc.nextInt();
                if (studentAge <= 0) {
                    System.out.print("Vui long nhap so nguyen duong. \n");
                }
            } else {
                System.out.print("Vui long chi nhap so nguyen. \n");
                sc.next(); // Bo qua dau vao khong hop le
            }
        } while (studentAge <= 0);
        
        do {
            System.out.print("Diem TB: ");
            if (sc.hasNextDouble()) {
                studentGPA = sc.nextDouble();
                if (studentGPA <= 0.0) {
                    System.out.print("Vui long nhap so duong. \n");
                } 
            } else {
                System.out.print("Vui long chi nhap so. \n");
                sc.next();
            }
        } while (studentGPA <= 0.0);
        
        String input = "";
        do {
            System.out.print("Xep loai (A/B/C...): ");
            if (sc.hasNext()) {
                input = sc.next();
                if (input.length() != 1 || !((input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') || (input.charAt(0) >= 'a' && input.charAt(0) <= 'z'))) {
                    System.out.print("Vui long chi nhap 1 chu cai A/B/C... \n");
                } else {
                    studentLevel = input.charAt(0);
                }
            } else {
                System.out.print("Vui long chi nhap 1 chu cai A/B/C... \n");
                sc.next();
            }
        } while (input.length() != 1 || !((input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') || (input.charAt(0) >= 'a' && input.charAt(0) <= 'z')));
        
        do {
            System.out.print("Tot nghiep (true/false): ");
            if (sc.hasNextBoolean()) {
                studentStatus = sc.nextBoolean();
                break;
            } else {
                System.out.print("Vui long chi nhap true hoac false. \n");
                sc.next();
            }
        } while (true);
        
        // Xuat du lieu ra man hinh
        String isGraduated = studentStatus ? "Da xet" : "Chua xet";
        System.out.printf("\n=== THONG TIN SINH VIEN ===\nHo ten: %s \nTuoi: %d\nDiem TB: %.2f \nXep loai: %c \nTot nghiep: %s\n", studentName, studentAge, studentGPA, studentLevel, isGraduated);
        */
        
        double x, y;
        System.out.println("\n=== THUC HIEN MOT SO PHEP TINH DON GIAN ===");
        do {
            System.out.print("x = ");
            if (sc.hasNextDouble()) {
                x = sc.nextDouble();
                break;
            } else {
                System.out.println("Vui long nhap mot so.");
                sc.next();
            }
        } while (true);
        
        do {
            System.out.print("y = ");
            if (sc.hasNextDouble()) {
                y = sc.nextDouble();
                break;
            } else {
                System.out.println("Vui long nhap mot so.");
                sc.next();
            }
        } while (true);
        
        System.out.printf("x = %.2f \ny = %.2f \nTong: %.2f\nHieu: %.2f\nTich: %.2f\nThuong: %.2f\nPhan du: %.2f", x, y, x + y, x - y, x * y, x / y, x % y);
        
        sc.close();
    }
}
