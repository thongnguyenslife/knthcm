package basic;

import java.util.Scanner;

public class BasicArrays2D {
    static Scanner sc = new Scanner(System.in);
    static int rows = 0, cols = 0; // Kich thuoc ma tran, rows la hang, cols la cot
    static int[][] mat = new int[0][0];
    static int[][] backup = new int[0][0];

    public static void menuHandMade() {
        while (true) {
            System.out.println("\n=== MENU BasicArrays2D ===");
            System.out.println("1.  Nhap ma tran moi");
            System.out.println("2.  In ma tran");
            System.out.println("3.  Tong / Min / Max");
            System.out.println("4.  Tong tung hang & tung cot");
            System.out.println("5.  Tong duong cheo chinh & phu (vuong)");
            System.out.println("6.  Chuyen vi (transpose)");
            System.out.println("7.  Xoay 90 do (clockwise)");
            System.out.println("8.  Tim tuyen tinh (in ra tat ca vi tri)");
            System.out.println("9.  Sap xep tang dan tung hang (Bubble)");
            System.out.println("10. Phuc hoi ve lan nhap dau tien");
            System.out.println("0.  Thoat");
            System.out.print("\n>> Chon: ");

            if (!sc.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long chon lai. ");
                sc.next();
                continue;
            }

            int c = sc.nextInt();

            switch (c) {
                case 1 -> {
                    inputMatrix();
                }

                case 2 -> {
                    ensureHasMatrix(true);
                    printMatrix(mat);
                }

                case 3 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    int sum = sumMatrix(mat);
                    int min = minMatrix(mat);
                    int max = maxMatrix(mat);
                    System.out.printf("Sum = %d, Min = %d, Max = %d\n", sum, min, max);
                }

                case 4 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    sumRowsAndCols(mat);
                }

                case 5 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    if (rows != cols) {
                        System.out.println("Chi tinh cheo khi ma tran vuong.");
                    } else {
                        printMatrix(mat);
                        System.out.printf("\nTong cheo chinh: %d\n", mainDiagSum(mat));
                        System.out.printf("Tong cheo phu: %d\n", secondaryDiagSum(mat));
                    }
                }

                case 6 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    transpose();
                    System.out.println("Da chuyen vi.");
                    printMatrix(mat);
                }

                case 7 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    rotate90Clockwise();
                    System.out.println("Da xoay 90 do (clockwise).");
                    printMatrix(mat);
                }

                case 8 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    linearSearch();
                }

                case 9 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    sortEachRowAscending();
                    System.out.println("Da sap xep tang dan tung hang (Bubble).");
                    printMatrix(mat);
                }

                case 10 -> {
                    if (!ensureHasMatrix(true))
                        break;
                    printMatrix(mat);
                    restoreMatrix();
                    printMatrix(mat);
                }

                case 0 -> {
                    System.out.println("Tam biet! ");
                    sc.close();
                    return;
                }

                default -> System.out.println("Lua chon khong hop le. Vui long chon lai. ");
            }
        }
    }

    public static void restoreMatrix() {
        mat = copyMatrix(backup);
        rows = mat.length;
        cols = mat[0].length;
        System.out.println("\nDa phuc hoi ma tran ve lan nhap dau tien: ");
    }

    private static void sumRowsAndCols(int[][] m) {
        int sumRows = 0, sumCols = 0;

        System.out.println("");

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sumRows += m[i][j];
            }

            System.out.printf("Tong hang %d: %d\n", i, sumRows);
        }

        for (int j = 0; j < m[0].length; j++) {
            for (int i = 0; i < m.length; i++) {
                sumCols += m[i][j];
            }

            System.out.printf("Tong cot %d: %d\n", j, sumCols);
        }
    }

    public static void sortEachRowAscending() {
        for (int r = 0; r < mat.length; r++) {
            bubbleSortRow(r);
        }
    }

    public static void bubbleSortRow(int r) {
        if (mat[r].length < 2)
            return;

        for (int pass = 0; pass < mat[r].length; pass++) {
            boolean swaped = false;

            for (int j = 0; j < mat[r].length - 1 - pass; j++) {
                if (mat[r][j] > mat[r][j + 1]) {
                    int temp = mat[r][j];
                    mat[r][j] = mat[r][j + 1];
                    mat[r][j + 1] = temp;
                    swaped = true;
                }
            }

            if (!swaped)
                break;
        }
    }

    public static void linearSearch() {
        int target;

        while (true) {
            System.out.print("Nhap gia tri can tim (Nhan -999 de thoat): ");
            if (!sc.hasNextInt()) {
                System.out.println("Gia tri khong hop le.");
                sc.next();
                continue;
            }
            target = sc.nextInt();
            if (target == -999) {
                System.out.println("Thoat tim kiem.");
                break;
            }

            boolean found = false;
            System.out.printf("Vi tri cua %d: ", target);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (target == mat[i][j]) {
                        System.out.print("[" + i + "," + j + "] ");
                        found = true;
                    }
                }
            }

            if (!found)
                System.out.print("(khong tim thay)");
            System.out.println();
        }
    }

    public static void rotate90Clockwise() {
        // Xoay 90 cho cả khong vuong: xoay = transpose + dao tung hang
        transpose(); // giờ kích thước là [cols x rows] cũ
        // Dao tung hang (reverse từng hàng)

        for (int i = 0; i < rows; i++) {
            int l = 0, r = cols - 1;

            while (l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++;
                r--;
            }
        }
    }

    public static void transpose() {
        // Hỗ trợ cả ma trận không vuông: tạo ma trận mới [cols x rows]
        int[][] t = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                t[j][i] = mat[i][j];

        mat = t;
        int tmp = rows;
        rows = cols;
        cols = tmp;
    }

    public static int secondaryDiagSum(int[][] m) {
        int sum = 0;

        for (int i = 0; i < m.length; i++) {
            sum += m[i][m.length - 1 - i];
        }

        return sum;
    }

    public static int mainDiagSum(int[][] m) {
        int sum = 0;

        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }

        return sum;
    }

    public static int maxMatrix(int[][] m) {
        int max = m[0][0];

        for (int i = 0; i < m.length; i++) {
            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }

        return max;
    }

    public static int minMatrix(int[][] m) {
        int min = m[0][0];

        for (int i = 0; i < m.length; i++) {
            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] < min) {
                    min = m[i][j];
                }
            }
        }

        return min;
    }

    public static int sumMatrix(int[][] m) {
        int sum = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
            }
        }

        return sum;
    }

    public static void printMatrix(int[][] m) {
        if (!ensureHasMatrix(true)) {
            return;
        }

        System.out.println("Ma tran hien tai: ");

        for (int i = 0; i < m.length; i++) { // Duyệt từng hàng
            for (int j = 0; j < m[i].length; j++) { // Duyệt từng cột trong hàng
                System.out.print(m[i][j] + (j == m[i].length - 1 ? "" : " "));
            }

            System.out.println();
        }
    }

    // warn la canh bao khi ma tran chua hop le
    public static boolean ensureHasMatrix(boolean warn) {
        boolean isMat = (mat != null && mat.length > 0 && mat[0].length > 0);

        if (warn && !isMat) {
            System.out.println("Ban chua nhap ma tran. Vui long chon 1 de nhap.");
        }

        return isMat;
    }

    public static int[][] copyMatrix(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;

        int[][] copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = m[i][j];
            }
        }

        return copy;
    }

    public static void inputMatrix() {
        rows = readPositiveInt("Nhap so hang: ");
        cols = readPositiveInt("Nhap so cot: ");

        mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // mat[i][j] = readInt(String.format("Nhap phan tu mat[%d][%d]: ", i, j));
                mat[i][j] = readInt("Nhap phan tu [" + i + "][" + j + "]: ");
            }
        }

        backup = copyMatrix(mat);
        System.out.println("Da nhap ma tran.");
    }

    // Ham kiem tra dieu kien nhap so nguyen duong
    public static int readPositiveInt(String msg) {
        int n = -1;

        do {
            System.out.printf(msg);
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Vui long nhap so nguyen duong. ");
                }
            } else {
                System.out.println("Vui long nhap so nguyen. ");
                sc.next();
            }
        } while (n <= 0);

        return n;
    }

    // Ham kiem tra dieu kien nhap so nguyen
    public static int readInt(String msg) {
        int n = -1;

        do {
            System.out.printf(msg);
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                break;
            } else {
                System.out.println("Vui long nhap so nguyen. ");
                sc.next();
            }
        } while (true);

        return n;
    }

    public static void main(String[] args) {
        menuHandMade();
    }
}
