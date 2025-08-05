package knthcm.basic;

import java.util.Scanner;

public class BasicArrays {
    static Scanner sc = new Scanner(System.in);
    static int n; // So luong phan tu
    static int[] myArr = {}; // ~ int[] = new int[0];
    
    public static int[] inputMyArr() {
        do {
            System.out.print("Nhap so luong phan tu: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Vui long nhap so nguyen duong.");
                } 
            } else {
                System.out.println("Vui long nhap so.");
                sc.next();
            }
        } while (n <= 0);
        
        myArr = new int[n];
         
        for (int i = 0; i < n; i++) {
            do {
                System.out.printf("Nhap phan tu thu %d: ", (i + 1));
                if (sc.hasNextInt()) {
                    myArr[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Vui long nhap so nguyen.");
                    sc.next();
                }
            } while (true);
        }
        
        return myArr;
    }
    
    public static void printMyArr() {
        if (myArr.length == 0) {
            System.out.println("Ban chua nhap mang. Vui long nhap mang moi. ");
        } else {
            System.out.print("Mang cua ban la: ");
            for (int i = 0; i < myArr.length; i++) {
                System.out.print(myArr[i] + (i == myArr.length - 1 ? "\n" : " "));
            }
        }
    }
    
    public static int sumMyArr() {
        int sum = 0;
        
        for (int i : myArr) {
            sum += i;
        }
        
        return sum;
    }
    
    public static int minMyArr() {
        int min = myArr[0];
        
        for (int i : myArr) {
            if (i < min) {
                min = i;
            }
        }
        
        return min;
    }
    
    public static int maxMyArr() {
        int max = myArr[0];
        
        for (int i = 1; i < myArr.length; i++) {
            if (max < myArr[i]) {
                max = myArr[i];
            }
        }
        
        return max;
    }
    
    
    // Ham dao nguoc mang
    public static int[] reverseMyArr() {
        for (int l = 0, r = myArr.length - 1; l < r; l++, r--) {
            int temp = myArr[l];
            myArr[l] = myArr[r];
            myArr[r] = temp;
        }
    
        return myArr;
    }
    
    // Ham them 1 phan tu vao cuoi mang
    public static int[] pushBackMyArr() {
        int[] tempMyArr = new int[myArr.length + 1];
        
        // Sao chep du lieu sang mang moi
        for (int i = 0; i < tempMyArr.length - 1; i++) {
            tempMyArr[i] = myArr[i];
        }
        
        do {
            System.out.printf("Nhap phan tu thu %d: ", (myArr.length + 1));
            if (sc.hasNextInt()) {
                tempMyArr[myArr.length] = sc.nextInt();
                break;
            } else {
                System.out.println("Vui long nhap so nguyen.");
                sc.next();
            }
       } while (true);
       
       return myArr = tempMyArr;
    }
    
    
    public static void menuHandMade() {
         while (true) {
            System.out.println("\n=== MENU BasicArrays HandMade ===");
            System.out.println("1. Nhap mang moi");
            System.out.println("2. In mang");
            System.out.println("3. Tong / Min / Max");
            System.out.println("4. Dao nguoc");
            System.out.println("5. Them phan tu cuoi");
            System.out.println("6. Xoa phan tu (index)");
            System.out.println("7. Sap xep Bubble");
            System.out.println("8. Sap xep Selection");
            System.out.println("9. Sap xep Insertion");
            System.out.println("10. Sap xep QuickSort");
            System.out.println("11. Tim tuyen tinh");
            System.out.println("12. Tim nhi phan (dang sort)");
            System.out.println("0. Thoat");
            System.out.print("\n>> Chon: ");
            
            // Kiem tra dieu kien nhap
            if (!sc.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
                sc.next();
                continue;
            }
            
            int c = sc.nextInt();
            
            switch (c) {
                case 1 -> {
                    inputMyArr();
                }
                
                case 2 -> {
                    printMyArr();
                }
                
                case 3 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang moi. ");
                    } else {
                        System.out.printf("Sum = %d | Min = %d | Max = %d\n", sumMyArr(), minMyArr(), maxMyArr());
                    }
                }
                
                case 4 -> {
                    if (myArr.length == 0) {
                            System.out.println("Ban chua nhap mang. Vui long nhap mang moi. ");
                    } else {
                        reverseMyArr();
                        System.out.print("Da dao nguoc mang. ");
                        printMyArr();
                    }
                }
                
                case 5 -> {
                    if (myArr.length == 0) {
                            System.out.println("Ban chua nhap mang. Vui long nhap mang moi. ");
                    } else {
                        pushBackMyArr();
                        System.out.print("Da them 1 phan tu vao cuoi mang. ");
                        printMyArr();
                    }
                }
                
                case 6 -> {
                
                }
                
                case 7 -> {
                
                }
                
                case 8 -> {
                
                }
                
                case 9 -> {
                
                }
                
                case 10 -> {
                
                }
                
                case 11 -> {
                
                }
                
                case 12 -> {
                
                }
                
                case 0 -> {
                    System.out.println("Tam biet!");
                    sc.close();
                    return;
                }
                
                default -> System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }
    
    public static void main(String[] args) {
        menuHandMade();
        
        //inputMyArr();
      
        //printMyArr();
        
        sc.close();
    }
}
