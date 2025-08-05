package knthcm.basic;

import java.util.Scanner;

public class BasicArrays {
    static Scanner sc = new Scanner(System.in);
    static int n; // So luong phan tu
    static int[] myArr = {}; // ~ int[] = new int[0];
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MENU BasicArrays HandMade ===");
            System.out.println("1. Nhap mang moi");
            System.out.println("2. In mang");
            System.out.println("3. Tong / Min / Max");
            System.out.println("4. Đao nguoc");
            System.out.println("5. Them phần tử cuối");
            System.out.println("6. Xóa phần tử (index)");
            System.out.println("7. Sắp xếp Bubble");
            System.out.println("8. Sắp xếp Selection");
            System.out.println("9. Sắp xếp Insertion");
            System.out.println("10. Sắp xếp QuickSort");
            System.out.println("11. Tìm tuyến tính");
            System.out.println("12. Tìm nhị phân (đang sort)");
            System.out.println("0. Thoát");
            System.out.println(">> Chọn: ");
            
            // Kiem tra dieu kien nhap
            if (!sc.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
                sc.next();
                continue;
            }
            
            int c = sc.nextInt();
            
            switch (c) {
            
            }
        }
    }
}
