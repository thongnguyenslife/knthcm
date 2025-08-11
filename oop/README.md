# OOP Menu

Gồm **6 file**:

- `oop.model.Person` *(trừu tượng, đóng gói name/age)*
- `oop.model.Student` *(kế thừa, thêm id/gpa/grade/graduated)*
- `oop.repository.StudentRepository` *(interface)*
- `oop.repository.InMemoryStudentRepository` *(Map<Integer,Student>)*
- `oop.service.StudentService` *(nghiệp vụ + sắp xếp + update linh hoạt)*
- `oop.app.Main` *(menu CLI)*

---

## 🚀 Chạy nhanh

> Mặc định theo cấu trúc Maven-like `src/main/java`. Nếu bạn đang ở cấu trúc khác, xem thêm phần **Ghi chú** bên dưới.

```bash
# Biên dịch
javac -d out $(find src/main/java -name "*.java")

# Chạy
java -cp out oop.app.Main
```

**Windows PowerShell**:
```powershell
$files = Get-ChildItem -Recurse -Filter *.java -Path src/main/java | ForEach-Object { $_.FullName }
javac -d out $files
java -cp out oop.app.Main
```

---

## 🧭 Menu
```
1. Seed demo
2. Thêm
3. Liệt kê
4. Sắp xếp: GPA ↓ + Tên
5. Sắp xếp: Tên A → Z
6. Sắp xếp: Tuổi ↑ + Tên
7. Tìm theo tên (chứa)
8. Cập nhật theo ID (bỏ trống để giữ nguyên)
9. Xóa theo ID
0. Thoát
```

---

## 🧱 Mục tiêu thiết kế
- **Rõ ràng, dễ học**: tách Model / Repository / Service / App, mỗi lớp 1 trách nhiệm.
- **OOP vừa đủ**: dùng trừu tượng (`Person`), kế thừa (`Student`), interface (`StudentRepository`).
- **Linh hoạt nâng cấp**: có thể thay `InMemoryStudentRepository` bằng DB mà không đổi `Service` / `Main`.
- **Sắp xếp & cập nhật đa dạng**: comparator/strategy đặt ở `Service` để mở rộng dễ dàng.

---

## 📝 Ghi chú
- Nếu dự án đặt mã nguồn thẳng trong package `oop/`, bạn có thể biên dịch nhanh như sau:
  ```bash
  javac -d out $(find . -name "*.java")
  java -cp out oop.app.Main
  ```
- Yêu cầu: **JDK 11+** (khuyến nghị JDK 21). Kiểm tra bằng `java -version` và `javac -version`.
- Nên chạy trong terminal UTF-8 để hiển thị tiếng Việt chuẩn.

---

> Gợi ý: thêm test dữ liệu trong `Seed demo` để nhanh chóng kiểm tra chức năng sắp xếp/tìm kiếm/cập nhật/xóa.
