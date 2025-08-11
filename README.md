# Học Phần Kỹ Năng Thực Hành Chuyên Môn CNTT – Đại Học Tôn Đức Thắng

![Java](https://img.shields.io/badge/Java-Programming-blue)
![JDK](https://img.shields.io/badge/Requires-JDK%2011%2B-informational)
![Build](https://img.shields.io/badge/Build-javac%20%7C%20CLI-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

> Bộ bài tập / demo thực hành Java: cú pháp cơ bản, xử lý chuỗi/mảng, mạng, và OOP (kèm **phiên bản OOP lược giản** dễ đọc).

---

## 📦 Cấu trúc thư mục chính

```text
knthcm/
├─ basic/               # Bài tập Java cơ bản (strings, arrays, functions,...)
├─ network/             # Ví dụ đơn giản về mạng
├─ oop/                 # Bản OOP đầy đủ (Person, Student, Repository, Service, ...)
│  ├─ app/Main.java
│  ├─ model/*.java
│  ├─ repository/*.java
│  ├─ service/*.java
│  └─ util/*.java
└─ troubleshoot/        # Ghi chú xử lý lỗi / mẹo vặt
```

> Ngoài ra có **bản OOP lược giản** (giữ OOP nhưng ít lớp/kế thừa) nằm trong gói nén đi kèm: `knthcm_oop_luocgian.zip` (thư mục `oop_simple/`).

---

## ⚙️ Yêu cầu môi trường

- **JDK 11+** (khuyến nghị JDK 17).
- Terminal (Bash trên Linux/macOS, PowerShell/CMD trên Windows).

Kiểm tra cài đặt:
```bash
java -version
javac -version
```

---

## ▶️ Cách biên dịch và chạy nhanh (tại thư mục `knthcm/`)

### Linux / macOS (Bash)
```bash
cd knthcm
javac $(find . -name "*.java")
# Chạy bài OOP đầy đủ
java oop.app.Main
```

### Windows PowerShell
```powershell
cd knthcm
$files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac $files
# Chạy bài OOP đầy đủ
java oop.app.Main
```

> Nếu dùng **CMD** cổ điển, có thể dùng IDE (IntelliJ/Eclipse/VS Code) để build cho thuận tiện.

---

## 🧩 OOP lược giản (tuỳ chọn)

Phiên bản rút gọn giữ tính OOP nhưng:
- Chỉ còn **`Student`** (không kế thừa `Person`).
- Gộp **Repository + Service** thành **`StudentManager`** (CRUD, tìm kiếm, sắp xếp).
- Comparator đặt ngay trong `StudentManager` để gọn.

**Cấu trúc rút gọn**:

```text
oop_simple/
├─ model/Student.java
├─ manager/StudentManager.java
└─ app/Main.java
```

**Build & Run (tại thư mục `oop_simple/`)**

```bash
# Biên dịch
javac model/Student.java manager/StudentManager.java app/Main.java

# Chạy
java oop_simple.app.Main
```

> Bạn có thể import vào IDE hoặc giữ kiểu chạy bằng `javac/java` như trên.

---

## 🧪 I/O mẫu (OOP)

```
1) List  2) Add  3) Find  4) Sort GPA  5) Remove  0) Exit
Chon: 1
ID   | Ho ten                   | Age |  GPA | G | Trang thai     
-----+---------------------------+-----+------+---+----------------
S01  | Nguyen Van A             |  20 | 3.45 | A | Dang hoc      
S02  | Tran Thi B               |  21 | 2.60 | B | Dang hoc      
S03  | Le Van C                 |  19 | 1.95 | D | Tam nghi      
```

---

## 🧭 Gợi ý tổ chức bài học

- **basic/** → nắm cú pháp & thao tác dữ liệu.
- **network/** → khái niệm socket/mạng cơ bản.
- **oop/** → kiến trúc nhiều lớp (Model, Repository, Service, Util, App).
- **oop_simple/** → bản tối giản để luyện tư duy OOP rõ ràng trước khi mở rộng.

---

## 🤝 Đóng góp

- Fork repo, tạo **feature branch**, mở **Pull Request**.
- Code style: rõ ràng, tên biến/hàm có nghĩa, thêm bình luận khi cần.

---

## 📜 License

Phát hành theo giấy phép MIT. Xem file `LICENSE` (nếu có) hoặc thêm sau.

---

**Liên hệ / Góp ý:** vui lòng mở Issue trên GitHub hoặc để lại comment trong PR. Chúc bạn học tốt! 🚀
