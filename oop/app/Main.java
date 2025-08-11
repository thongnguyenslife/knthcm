package oop.app;

import oop.model.Student;
import oop.repository.*;
import oop.service.StudentService;

import java.util.*;

// Menu kiểu cũ: seed / add / list / sort / search / update / delete
public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        StudentRepository repo = new InMemoryStudentRepository();
        StudentService service = new StudentService(repo);

        while (true) {
            printMenu();
            System.out.print("Chọn: ");
            String c = SC.nextLine().trim();
            switch (c) {
                case "0": System.out.println("Tạm biệt!"); return;
                case "1": service.seedDemo(); System.out.println(">> Đã seed 4 sinh viên."); break;
                case "2": handleAdd(service); break;
                case "3": printList(service.listAll()); break;
                case "4": printList(service.sortByGpaDescThenName()); break;
                case "5": printList(service.sortByNameAsc()); break;
                case "6": printList(service.sortByAgeAscThenName()); break;
                case "7": handleSearch(service); break;
                case "8": handleUpdate(service); break;
                case "9": handleDelete(service); break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("====== QUẢN LÝ SINH VIÊN (OOP - Menu) ======");
        System.out.println("1. Seed demo data");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Liệt kê tất cả");
        System.out.println("4. Sắp xếp: GPA ↓ + Tên");
        System.out.println("5. Sắp xếp: Tên A → Z");
        System.out.println("6. Sắp xếp: Tuổi ↑ + Tên");
        System.out.println("7. Tìm theo tên (chứa)");
        System.out.println("8. Cập nhật theo ID (bỏ trống để giữ nguyên)");
        System.out.println("9. Xóa theo ID");
        System.out.println("0. Thoát");
    }

    // ====== Các handler ======
    private static void handleAdd(StudentService service) {
        String name = readLine("Họ tên: ");
        int age = readInt("Tuổi: ", 1, 150);
        double gpa = readDouble("GPA [0..10]: ", 0, 10);
        char grade = readChar("Grade (A/B/C...): ");
        boolean graduated = readBoolean("Đã tốt nghiệp? (y/n): ");
        Student s = service.add(name, age, gpa, grade, graduated);
        System.out.println(">> Đã thêm: " + s);
    }

    private static void handleSearch(StudentService service) {
        String key = readLine("Nhập từ khóa: ");
        printList(service.searchByName(key));
    }

    private static void handleUpdate(StudentService service) {
        int id = readInt("ID cần cập nhật: ", 1, Integer.MAX_VALUE);
        String name = readOptionalString("Họ tên mới (bỏ trống để giữ nguyên): ");
        Integer age = readOptionalInt("Tuổi mới (bỏ trống để giữ nguyên): ", 1, 150);
        Double gpa = readOptionalDouble("GPA mới [0..10] (bỏ trống để giữ nguyên): ", 0, 10);
        Character grade = readOptionalChar("Grade mới (bỏ trống để giữ nguyên): ");
        Boolean graduated = readOptionalBoolean("Đã tốt nghiệp? (bỏ trống để giữ nguyên): ");
        boolean ok = service.update(id, name, age, gpa, grade, graduated);
        System.out.println(ok ? ">> Cập nhật thành công." : ">> Không tìm thấy student id=" + id);
    }

    private static void handleDelete(StudentService service) {
        int id = readInt("Nhập ID cần xóa: ", 1, Integer.MAX_VALUE);
        boolean ok = service.delete(id);
        System.out.println(ok ? ">> Đã xóa." : ">> Không tìm thấy ID.");
    }

    private static void printList(List<Student> list) {
        if (list.isEmpty()) { System.out.println("(Danh sách rỗng)"); return; }
        System.out.println("ID   | Họ tên                   | Age |  GPA | G | Trạng thái   ");
        System.out.println("-----+--------------------------+-----+------+---+--------------");
        for (Student s : list) System.out.println(s);
    }

    // ====== Hàm nhập liệu gọn trong Main (không tạo lớp util để bớt file) ======
    private static String readLine(String msg) { System.out.print(msg); return SC.nextLine(); }

    private static int readInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) { System.out.println("Giá trị phải trong ["+min+".."+max+"]."); continue; }
                return v;
            } catch (NumberFormatException e) { System.out.println("Vui lòng nhập số nguyên."); }
        }
    }

    private static double readDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v < min || v > max) { System.out.println("Giá trị phải trong ["+min+".."+max+"]."); continue; }
                return v;
            } catch (NumberFormatException e) { System.out.println("Vui lòng nhập số thực."); }
        }
    }

    private static char readChar(String msg) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim();
            if (!s.isEmpty() && Character.isLetter(s.charAt(0))) return Character.toUpperCase(s.charAt(0));
            System.out.println("Vui lòng nhập 1 ký tự chữ.");
        }
    }

    private static boolean readBoolean(String msg) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim().toLowerCase();
            if (s.equals("y") || s.equals("yes") || s.equals("1") || s.equals("true")) return true;
            if (s.equals("n") || s.equals("no") || s.equals("0") || s.equals("false")) return false;
            System.out.println("Vui lòng nhập y/n.");
        }
    }

    // Optional: để cập nhật (rỗng => null)
    private static String readOptionalString(String msg) {
        System.out.print(msg);
        String s = SC.nextLine();
        return s.trim().isEmpty() ? null : s;
    }
    private static Integer readOptionalInt(String msg, int min, int max) {
        System.out.print(msg);
        String s = SC.nextLine().trim();
        if (s.isEmpty()) return null;
        try {
            int v = Integer.parseInt(s);
            if (v < min || v > max) { System.out.println("Bỏ qua giá trị không hợp lệ."); return null; }
            return v;
        } catch (NumberFormatException e) { System.out.println("Bỏ qua giá trị không hợp lệ."); return null; }
    }
    private static Double readOptionalDouble(String msg, double min, double max) {
        System.out.print(msg);
        String s = SC.nextLine().trim();
        if (s.isEmpty()) return null;
        try {
            double v = Double.parseDouble(s);
            if (v < min || v > max) { System.out.println("Bỏ qua giá trị không hợp lệ."); return null; }
            return v;
        } catch (NumberFormatException e) { System.out.println("Bỏ qua giá trị không hợp lệ."); return null; }
    }
    private static Character readOptionalChar(String msg) {
        System.out.print(msg);
        String s = SC.nextLine().trim();
        if (s.isEmpty()) return null;
        return Character.isLetter(s.charAt(0)) ? Character.toUpperCase(s.charAt(0)) : null;
    }
    private static Boolean readOptionalBoolean(String msg) {
        System.out.print(msg);
        String s = SC.nextLine().trim().toLowerCase();
        if (s.isEmpty()) return null;
        if (s.equals("y") || s.equals("yes") || s.equals("1") || s.equals("true")) return true;
        if (s.equals("n") || s.equals("no") || s.equals("0") || s.equals("false")) return false;
        System.out.println("Bỏ qua giá trị không hợp lệ.");
        return null;
    }
}