package oop.app;

import oop.model.Student;
import oop.repository.*;
import oop.service.StudentService;

import java.util.*;

// Menu kieu cu: seed / add / list / sort / search / update / delete
public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        StudentRepository repo = new InMemoryStudentRepository();
        StudentService service = new StudentService(repo);

        while (true) {
            printMenu();
            System.out.print("Chon: ");
            String c = SC.nextLine().trim();
            switch (c) {
                case "0":
                    System.out.println("Tam biet!");
                    return;
                case "1":
                    service.seedDemo();
                    System.out.println(">> Da seed 31 sinh vien.");
                    break;
                case "2":
                    handleAdd(service);
                    break;
                case "3":
                    printList(service.listAll());
                    break;
                case "4":
                    printList(service.sortByGpaDescThenName());
                    break;
                case "5":
                    printList(service.sortByNameAsc());
                    break;
                case "6":
                    printList(service.sortByAgeAscThenName());
                    break;
                case "7":
                    handleSearch(service);
                    break;
                case "8":
                    handleUpdate(service);
                    break;
                case "9":
                    handleDelete(service);
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("====== QUAN LY SINH VIEN (OOP - Menu) ======");
        System.out.println("1. Seed demo data");
        System.out.println("2. Them sinh vien");
        System.out.println("3. Liet ke tat ca");
        System.out.println("4. Sap xep: GPA giam + Ten");
        System.out.println("5. Sap xep: Ten A -> Z");
        System.out.println("6. Sap xep: Tuoi tang + Ten");
        System.out.println("7. Tim theo ten (chua)");
        System.out.println("8. Cap nhat theo ID (bo trong de giu nguyen)");
        System.out.println("9. Xoa theo ID");
        System.out.println("0. Thoat");
    }

    // ====== Cac handler ======
    private static void handleAdd(StudentService service) {
        String name = readLine("Ho ten: ");
        int age = readInt("Tuoi: ", 1, 150);
        double gpa = readDouble("GPA [0..10]: ", 0, 10);
        char grade = readChar("Grade (A/B/C...): ");
        boolean graduated = readBoolean("Da tot nghiep? (y/n): ");
        Student s = service.add(name, age, gpa, grade, graduated);
        System.out.println(">> Da them: " + s);
    }

    private static void handleSearch(StudentService service) {
        String key = readLine("Nhap tu khoa: ");
        printList(service.searchByName(key));
    }

    private static void handleUpdate(StudentService service) {
        int id = readInt("ID can cap nhat: ", 1, Integer.MAX_VALUE);
        String name = readOptionalString("Ho ten moi (bo trong de giu nguyen): ");
        Integer age = readOptionalInt("Tuoi moi (bo trong de giu nguyen): ", 1, 150);
        Double gpa = readOptionalDouble("GPA moi [0..10] (bo trong de giu nguyen): ", 0, 10);
        Character grade = readOptionalChar("Grade moi (bo trong de giu nguyen): ");
        Boolean graduated = readOptionalBoolean("Da tot nghiep? (bo trong de giu nguyen): ");
        boolean ok = service.update(id, name, age, gpa, grade, graduated);
        System.out.println(ok ? ">> Cap nhat thanh cong." : ">> Khong tim thay student id=" + id);
    }

    private static void handleDelete(StudentService service) {
        int id = readInt("Nhap ID can xoa: ", 1, Integer.MAX_VALUE);
        boolean ok = service.delete(id);
        System.out.println(ok ? ">> Da xoa." : ">> Khong tim thay ID.");
    }

    private static void printList(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("(Danh sach rong)");
            return;
        }
        System.out.println("ID   | Ho ten                   | Age |  GPA | G | Trang thai   ");
        System.out.println("-----+--------------------------+-----+------+---+--------------");
        for (Student s : list)
            System.out.println(s);
    }

    // ====== Ham nhap lieu gon trong Main (khong tao lop util de bot file) ======
    private static String readLine(String msg) {
        System.out.print(msg);
        return SC.nextLine();
    }

    private static int readInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.println("Gia tri phai trong [" + min + ".." + max + "].");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen.");
            }
        }
    }

    private static double readDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v < min || v > max) {
                    System.out.println("Gia tri phai trong [" + min + ".." + max + "].");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so thuc.");
            }
        }
    }

    private static char readChar(String msg) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim();
            if (!s.isEmpty() && Character.isLetter(s.charAt(0)))
                return Character.toUpperCase(s.charAt(0));
            System.out.println("Vui long nhap 1 ky tu chu.");
        }
    }

    private static boolean readBoolean(String msg) {
        while (true) {
            System.out.print(msg);
            String s = SC.nextLine().trim().toLowerCase();
            if (s.equals("y") || s.equals("yes") || s.equals("1") || s.equals("true"))
                return true;
            if (s.equals("n") || s.equals("no") || s.equals("0") || s.equals("false"))
                return false;
            System.out.println("Vui long nhap y/n.");
        }
    }

    // Optional: de cap nhat (rong => null)
    private static String readOptionalString(String msg) {
        System.out.print(msg);
        String s = SC.nextLine();
        return s.trim().isEmpty() ? null : s;
    }

    private static Integer readOptionalInt(String msg, int min, int max) {
        System.out.print(msg);
        String s = SC.nextLine().trim();
        if (s.isEmpty())
            return null;
        try {
            int v = Integer.parseInt(s);
            if (v < min || v > max) {
                System.out.println("Bo qua gia tri khong hop le.");
                return null;
            }
            return v;
        } catch (NumberFormatException e) {
            System.out.println("Bo qua gia tri khong hop le.");
            return null;
        }
    }

    private static Double readOptionalDouble(String msg, double min, double max) {
        System.out.print(msg);
        String s = SC.nextLine().trim();
        if (s.isEmpty())
            return null;
        try {
            double v = Double.parseDouble(s);
            if (v < min || v > max) {
                System.out.println("Bo qua gia tri khong hop le.");
                return null;
            }
            return v;
        } catch (NumberFormatException e) {
            System.out.println("Bo qua gia tri khong hop le.");
            return null;
        }
    }

    private static Character readOptionalChar(String msg) {
        System.out.print(msg);
        String s = SC.nextLine().trim();
        if (s.isEmpty())
            return null;
        return Character.isLetter(s.charAt(0)) ? Character.toUpperCase(s.charAt(0)) : null;
    }

    private static Boolean readOptionalBoolean(String msg) {
        System.out.print(msg);
        String s = SC.nextLine().trim().toLowerCase();
        if (s.isEmpty())
            return null;
        if (s.equals("y") || s.equals("yes") || s.equals("1") || s.equals("true"))
            return true;
        if (s.equals("n") || s.equals("no") || s.equals("0") || s.equals("false"))
            return false;
        System.out.println("Bo qua gia tri khong hop le.");
        return null;
    }
}
