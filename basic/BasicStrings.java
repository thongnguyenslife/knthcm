package basic;

import java.util.Scanner;

public class BasicStrings {
    static Scanner sc = new Scanner(System.in);
    static String str = "";

    public static void menuHandMade() {
        while (true) {
            System.out.println("\n=== MENU BasicStrings ===");
            System.out.println("1.  Nhap chuoi moi");
            System.out.println("2.  In chuoi hien tai");
            System.out.println("3.  Do dai chuoi");
            System.out.println("4.  Dao nguoc chuoi");
            System.out.println("5.  Dem so tu");
            System.out.println("6.  Kiem tra palindrome (bo khoang trang, khong phan biet hoa thuong)");
            System.out.println("7.  Viet hoa chu cai dau moi tu (Title Case)");
            System.out.println("8.  Tim & thay the (find/replace)");
            System.out.println("9.  Xoa khoang trang thua (chuan hoa)");
            System.out.println("10. Xoa dau cau khoi chuoi (chuan hoa) ");
            System.out.println("11. Dem nguyen am / phu am / chu so / khoang trang");
            System.out.println("12. Tan suat ky tu");
            System.out.println("13. So sanh voi chuoi khac (equalsIgnoreCase + compareTo)");
            System.out.println("14. Noi them chuoi khac vao cuoi");
            System.out.println("0.  Thoat");
            System.out.print("\n>> Chon: ");

            if (!sc.hasNextInt()) {
                System.out.println("Lua chon khong hop le. Vui long chon lai. ");
                sc.next();
                continue;
            }

            int c = sc.nextInt();
            sc.nextLine(); // an new line

            switch (c) {
                case 1 -> {
                    inputString();
                }

                case 2 -> {
                    printString();
                }

                case 3 -> {
                    lengthString();
                }

                case 4 -> {
                    str = reverseString(str);
                    printString();
                }

                case 5 -> {
                    printString();
                    wordCount();
                }

                case 6 -> {
                    checkPalindrome();
                }

                case 7 -> {
                    printString();
                    titleCase();
                }

                case 8 -> {
                    findAndReplace();
                }

                case 9 -> {
                    printString();
                    str = removeExtraSpaces(str);
                    System.out.print("Da xoa khoang trang thua khoi chuoi. ");
                    printString();
                }

                case 10 -> {
                    printString();
                    str = removePunctuation(str);
                    System.out.print("Da xoa dau cau khoi chuoi. ");
                    printString();
                }

                case 11 -> {
                    printString();
                    countClasses(str);
                }

                case 12 -> {
                    printString();
                    charFrequency();
                }

                case 13 -> {
                    printString();
                    compareWithOther();
                }

                case 14 -> {
                    printString();
                    appendOther();
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

    public static void appendOther() {
        if (!ensureHasString()) {
            return;
        }

        String other_str = promptLine("Nhap chuoi khac: ");

        str += other_str;
        System.out.printf("Chuoi sau khi noi: \"%s\"\n", str);

    }

    public static void compareWithOther() {
        if (!ensureHasString()) {
            return;
        }

        String other_str = promptLine("Nhap chuoi khac: ");

        System.out.println("So sanh phan biet hoa/thuong: " + str.equals(other_str));
        System.out.println("So sanh khong phan biet hoa/thuong: " + str.equalsIgnoreCase(other_str));
        System.out.println("So sanh phan biet hoa/thuong: " + str.compareTo(other_str));
        System.out.println("So sanh khong phan biet hoa/thuong: " + str.compareToIgnoreCase(other_str));
    }

    public static void charFrequency() {
        if (!ensureHasString()) {
            return;
        }

        char[] char_str = myToCharMyArr(str);
        boolean[] counted = new boolean[char_str.length];

        System.out.print("Tan suat ky tu: ");

        for (int i = 0; i < char_str.length; i++) {
            if (counted[i]) {
                continue; // Bo qua neu ky tu da den
            }

            int count = 1;

            for (int j = i + 1; j < char_str.length; j++) {
                if (char_str[j] == char_str[i]) {
                    count++;
                    counted[j] = true;
                }
            }

            String k = (char_str[i] == ' ') ? "[space]" : ("" + char_str[i]);
            System.out.print(" " + k + " : " + count + " | ");
        }

        System.out.println("");
    }

    public static void countClasses(String s) {
        if (!ensureHasString()) {
            return;
        }

        int nguyenAm = 0, phuAm = 0, chuSo = 0, khoangTrang = 0;
        String strNguyenAm = "aeiouyAEIOUYáàảãạăắằẳẵặâấầẩẫậóòỏõọôốồổỗộơớờởỡợ"
                + "éèẻẽẹêếềểễệíìỉĩịúùủũụưứừửữựýỳỷỹỵ"
                + "ÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢ"
                + "ÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ";

        char[] char_str = myToCharMyArr(s);

        for (char c : char_str) {
            if (strNguyenAm.indexOf(c) >= 0) {
                nguyenAm++;
            } else if (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f') {
                khoangTrang++;
            } else if ((c >= '0' && c <= '9')) {
                chuSo++;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                phuAm++;
            }
        }

        System.out.printf("Nguyên âm: %d, Phu am: %d, Chu so: %d, Khoang trang: %d.\n", nguyenAm, phuAm, chuSo,
                khoangTrang);
    }

    // === Helpers ===
    // Ham nhap chuoi
    public static String promptLine(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    // Ham kiem tra co chuoi khong
    public static boolean ensureHasString() {
        if (str == null || str.isEmpty()) {
            System.out.println("Chua co chuoi. Vui long chon 1 de nhap chuoi. ");
            return false;
        }

        return true;
    }

    // === Features ===
    public static void inputString() {
        String s = promptLine("Nhap chuoi: ");
        str = s.trim();
        System.out.println("Da cap nhat chuoi. ");
    }

    public static void printString() {
        if (!ensureHasString()) {
            return;
        }

        System.out.println("Chuoi hien tai: \"" + str + "\"");
    }

    public static void printString(String s) {
        System.out.println("Chuoi hien tai: \"" + s + "\"");
    }

    public static void lengthString() {
        if (!ensureHasString()) {
            return;
        }

        System.out.printf("Do dai chuoi \"%s\" la: %d\n", str, str.length());
    }

    public static void swaped(char[] chars_str, int i, int j) {
        char temp = chars_str[i];
        chars_str[i] = chars_str[j];
        chars_str[j] = temp;
    }

    public static char[] myToCharMyArr(String s) {
        if (s == null) {
            return null;
        }

        char[] chars_str = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            chars_str[i] = s.charAt(i);
        }

        return chars_str;
    }

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        char[] chars_str = myToCharMyArr(s);

        int l = 0, r = chars_str.length - 1;

        while (l < r) {
            swaped(chars_str, l, r);
            l++;
            r--;
        }

        String msg = "";

        for (int i = 0; i < chars_str.length; i++) {
            msg += chars_str[i];
        }

        return msg;
    }

    // Ham xoa khoang trang du thua ~ replaceAll("\\s+", " ")
    public static String removeExtraSpaces(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.trim();

        boolean inSpace = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Nếu là ký tự khoảng trắng
            if (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f') {
                if (!inSpace) { // Chỉ thêm 1 khoảng trắng nếu trước đó chưa có
                    sb.append(' ');
                    inSpace = true;
                }
            } else {
                sb.append(c);
                inSpace = false; // Reset cờ khi gặp ký tự không phải khoảng trắng
            }
        }

        // return sb.toString();

        String result = ""; // Chuỗi rỗng ban đầu

        for (int i = 0; i < sb.length(); i++) {
            result += sb.charAt(i); // Nối từng ký tự
        }

        return result; // Trả về chuỗi đã tạo
    }

    // Ham xoa dau cau
    // Ham xoa dau cau (khong dung ham co san nhu replaceAll)
    public static String removePunctuation(String s) {
        if (s == null)
            return null;

        String punctuation = ".,;:!?()[]{}\"'`~@#$%^&*-_=+<>/\\|";
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean isPunct = false;
            for (int j = 0; j < punctuation.length(); j++) {
                if (c == punctuation.charAt(j)) {
                    isPunct = true;
                    break;
                }
            }

            if (!isPunct) {
                result += c; // thêm ký tự nếu không phải dấu câu
            }
        }

        return result;
    }

    public static void wordCount() {
        if (!ensureHasString()) {
            return;
        }

        // String words = str.trim().replaceAll("\\s+", " ");

        String words = removeExtraSpaces(str);
        words = removePunctuation(words);
        int count = words.isEmpty() ? 0 : words.split(" ").length;

        System.out.println("So tu: " + count);
    }

    public static void checkPalindrome() {
        if (!ensureHasString()) {
            return;
        }

        String words = removeExtraSpaces(str).toLowerCase();
        String reverseWords = reverseString(words);
        boolean isPalindrome = words.equals(reverseWords);
        System.out.printf("Chuoi \"%s\" co la Palindrome? " + (isPalindrome ? "Co\n" : "Khong\n") + "", str);
    }

    // Viet hoa chu cai dau
    public static void titleCase() {
        if (!ensureHasString()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        String words = removeExtraSpaces(str);

        for (String w : words.split(" ")) {
            if (w.isEmpty()) {
                continue;
            }

            if (w.length() == 1) {
                sb.append(Character.toUpperCase(w.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase());
            }

            sb.append(" ");
        }

        str = sb.toString().trim();
        System.out.println("In hoa chu cai dau moi tu: \"" + str + "\"");
    }

    public static void findAndReplace() {
        if (!ensureHasString()) {
            return;
        }

        String input = promptLine("Nhap tu/chuoi cam tim: ");

        if (input.isEmpty()) {
            System.out.println("Tu can tim khong duoc rong.");
            return;
        }

        String inputReplace = promptLine("Thay bang: ");

        String result = "";
        int i = 0;

        while (i < str.length()) {
            if (i <= str.length() - input.length() && str.substring(i, i + input.length()).equals(input)) {
                result += inputReplace;
                i += input.length();
            } else {
                result += str.charAt(i);
                i++;
            }
        }

        str = result; // Cập nhật lại chuỗi gốc
        System.out.println(">> Sau khi replace: \"" + str + "\"");
    }

    public static void main(String[] args) {
        menuHandMade();
    }
}