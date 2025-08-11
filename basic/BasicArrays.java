import java.util.Scanner;

public class BasicArrays {
    static Scanner sc = new Scanner(System.in);
    static int n; // So luong phan tu
    static int[] myArr = {};
    static int[] backupMyArr = {};

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
            System.out.println("13. Phuc hoi mang ve lan nhap dau tien");
            System.out.println("0. Thoat");
            System.out.print("\n>> Chon: ");

            if (!sc.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long chon lai. ");
                sc.next();
                continue;
            }

            int c = sc.nextInt();

            switch (c) {
                case 1 -> {
                    inputMyArr();
                }

                case 2 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                    }
                }

                case 3 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();

                        int sum = sumMyArr(), max = maxMyArr(), min = minMyArr();

                        System.out.printf("Sum = %d, Min = %d, Max = %d\n", sum, min, max);
                    }
                }

                case 4 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        reverseMyArr();
                        printMyArr();
                    }
                }

                case 5 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        pushBackMyArr();
                        printMyArr();
                    }
                }

                case 6 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        removeAtMyArr();
                        printMyArr();
                    }
                }

                case 7 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        bubbleSort();
                        printMyArr();
                    }
                }

                case 8 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        selectionSort();
                        printMyArr();
                    }
                }

                case 9 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        insertionSort();
                        printMyArr();
                    }
                }

                case 10 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        quickSort();
                        printMyArr();
                    }
                }

                case 11 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        linearSearch();
                        printMyArr();
                    }
                }

                case 12 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        printMyArr();
                        binarySearch();
                        printMyArr();
                    }
                }

                case 13 -> {
                    if (myArr.length == 0) {
                        System.out.println("Ban chua nhap mang. Vui long nhap mang va tiep tuc. ");
                    } else {
                        restoreMyArr();
                        printMyArr();
                    }
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

    public static void binarySearch() {
        int input = -1;

        insertionSort();
        printMyArr();

        do {
            System.out.print("Nhap phan tu can tim (Nhan -999 de thoat): ");

            if (!sc.hasNextInt()) {
                System.out.println("Gia tri khong hop le. Vui long nhap lai. ");
                sc.next();
            } else {
                input = sc.nextInt();

                if (input == -999) {
                    System.out.print("Thoat tim kiem. ");
                    break;
                }

                int l = 0, r = myArr.length - 1,
                        pos = -1;

                while (l <= r) {
                    int mid = l + (r - l) / 2;

                    if (myArr[mid] == input) {
                        pos = mid;
                        break;
                    }

                    if (myArr[mid] < input) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }

                if (pos >= 0) {
                    System.out.printf("Da tim thay gia tri %d tai vi tri: %d\n", input, pos);
                } else {
                    System.out.printf("Khong tim thay gia tri %d nao trong mang.\n ", input);
                }
            }
        } while (true);

        restoreMyArr();
    }

    public static void linearSearch() {
        int input = -1;

        do {
            System.out.print("Nhap phan tu can tim (Nhan -999 de thoat): ");

            if (!sc.hasNextInt()) {
                System.out.println("Gia tri khong hop le. Vui long nhap lai. ");
                sc.next();
            } else {
                input = sc.nextInt();

                if (input == -999) {
                    System.out.print("Thoat tim kiem. ");
                    break;
                }

                boolean found = false;

                System.out.printf("Da tim thay gia tri %d tai vi tri: ", input);

                for (int i = 0; i < myArr.length; i++) {
                    if (myArr[i] == input) {
                        System.out.print(i + " ");
                        found = true;
                    }
                }

                if (!found) {
                    System.out.printf("Khong tim thay gia tri %d nao trong mang.\n", input);
                } else {
                    System.out.println("");
                }
            }
        } while (true);
    }

    public static void quickSort() {
        quickSortRec(0, myArr.length - 1);
        System.out.print("Da sap xep Quick Sort. ");
    }

    public static void quickSortRec(int l, int r) {
        if (l >= r) {
            return; // Dieu kien dung neu mang rong hoac chi co 1 phan tu
        }

        // Lay chi so giua de so sanh
        int mid = l + (r - l) / 2;

        // Sap xep 3 chi so
        if (myArr[l] > myArr[mid]) {
            swaped(l, mid);
        }

        if (myArr[l] > myArr[r]) {
            swaped(l, r);
        }

        if (myArr[mid] > myArr[r]) {
            swaped(mid, r);
        }

        // Lay gia tri phan tu giua
        int pivot = myArr[mid];

        int lt = l, i = l, gt = r;

        while (i <= gt) {
            if (myArr[i] < pivot) {
                swaped(lt, i);
                lt++;
                i++;
            } else if (myArr[i] > pivot) {
                swaped(i, gt);
                gt--;
            } else {
                i++;
            }
        }

        quickSortRec(l, lt - 1);
        quickSortRec(gt + 1, r);
    }

    // Insertion Sort la dat mot gia tri key, neu (key - 1) > key thi dich sang phai
    // va (key - 1) = key
    public static void insertionSort() {
        for (int i = 1; i < myArr.length; i++) {
            int index_key = myArr[i];
            int j = i - 1;

            while (j >= 0 && myArr[j] > index_key) {
                myArr[j + 1] = myArr[j];
                j--;
            }

            myArr[j + 1] = index_key;
        }

        System.out.print("Da sap xep Insertion Sort. ");
    }

    // Selection Sort la moi vong lap, tim vi tri so min va chuyen doi no ra phia
    // truoc
    public static void selectionSort() {
        for (int i = 0; i < myArr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < myArr.length; j++) {
                if (myArr[j] < myArr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swaped(i, minIdx);
            }
        }

        System.out.print("Da sap xep Selection Sort. ");
    }

    // Bubble Sort la so sanh 2 so lien ke, chuyen doi so lon nhat ve cuoi cung, sau
    // do khong quan tam so
    // do
    // nua
    public static void bubbleSort() {
        for (int i = 0; i < myArr.length; i++) {
            boolean isSwaped = false;

            for (int j = 0; j < myArr.length - 1 - i; j++) {
                if (myArr[j] > myArr[j + 1]) {
                    swaped(j, j + 1);
                    isSwaped = true;
                }
            }

            if (!isSwaped) {
                break;
            }
        }

        System.out.print("Da sap xep Bubble Sort. ");
    }

    public static void removeAtMyArr() {
        int index = -1;
        int[] tempMyArr = new int[myArr.length - 1];

        do {
            System.out.print("Nhap vi tri can xoa: ");
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                if (index < 0 || index > myArr.length - 1) {
                    System.out.println("Vi tri khong hop le. Vui long nhap vi tri >= 0 va < do dai mang. ");
                }
            } else {
                System.out.println("Vi tri khong hop le. Vui long nhap lai. ");
                sc.next();
            }
        } while (index < 0 || index > myArr.length - 1);

        int index_key = myArr[index]; // Gia tri phan tu tai vi tri c cua mang myArr

        for (int i = 0; i < index; i++) {
            tempMyArr[i] = myArr[i];
        }

        for (int i = index + 1; i < myArr.length; i++) {
            tempMyArr[i - 1] = myArr[i];
        }

        // Khoi tao lai myArr
        myArr = new int[tempMyArr.length];

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = tempMyArr[i];
        }

        System.out.printf("Da xoa 1 phan tu co gia tri %d, tai vi tri %d. ", index_key, index);
    }

    public static void restoreMyArr() {
        myArr = new int[backupMyArr.length];

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = backupMyArr[i];
        }

        System.out.print("Mang da duoc phuc hoi ve lan nhap dau tien. \n");
    }

    public static void pushBackMyArr() {
        int[] tempMyArr = new int[myArr.length + 1];

        System.out.printf("Nhap phan tu thu %d: ", (myArr.length + 1));

        do {
            if (sc.hasNextInt()) {
                tempMyArr[myArr.length] = sc.nextInt();
                break;
            } else {
                System.out.println("Vui long nhap so nguyen. ");
                sc.next();
            }
        } while (true);

        for (int i = 0; i < myArr.length; i++) {
            tempMyArr[i] = myArr[i];
        }

        myArr = new int[tempMyArr.length];

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = tempMyArr[i];
        }

        System.out.print("Da them 1 phan tu vao cuoi mang. ");
    }

    public static void swaped(int i, int j) {
        int temp = myArr[i];
        myArr[i] = myArr[j];
        myArr[j] = temp;
    }

    public static void reverseMyArr() {
        for (int i = 0, j = myArr.length - 1; i < j; i++, j--) {
            swaped(i, j);
        }

        System.out.print("Da dao nguoc mang. ");
    }

    public static int maxMyArr() {
        int max = myArr[0];

        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] > max) {
                max = myArr[i];
            }
        }

        return max;
    }

    public static int minMyArr() {
        int min = myArr[0];

        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] < min) {
                min = myArr[i];
            }
        }

        return min;
    }

    public static int sumMyArr() {
        int sum = 0;

        for (int i = 0; i < myArr.length; i++) {
            sum += myArr[i];
        }

        return sum;
    }

    public static void printMyArr() {
        System.out.print("Mang cua ban la: ");

        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + (i == myArr.length - 1 ? "\n" : " "));
        }

        System.out.println("");
    }

    public static int[] inputMyArr() {
        do {
            System.out.print("Nhap so luong phan tu: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Vui long nhap so nguyen duong. ");
                }
            } else {
                System.out.println("Vui long nhap so. ");
                sc.next();
            }
        } while (n <= 0);

        myArr = new int[n];

        for (int i = 0; i < myArr.length; i++) {
            System.out.printf("Nhap phan tu thu %d: ", (i + 1));
            do {
                if (sc.hasNextInt()) {
                    myArr[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Vui long nhap so nguyen. ");
                    sc.next();
                }
            } while (true);
        }

        backupMyArr = new int[n];

        for (int i = 0; i < myArr.length; i++) {
            backupMyArr[i] = myArr[i];
        }

        return myArr;
    }

    public static void main(String[] args) {
        menuHandMade();
    }
}
