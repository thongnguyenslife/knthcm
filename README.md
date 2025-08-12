# Học Phần Kỹ Năng Thực Hành Chuyên Môn Công Nghệ Thông Tin Đại Học Tôn Đức Thắng

![Java](https://img.shields.io/badge/Java-Programming-blue)
![JDK](https://img.shields.io/badge/Requires-JDK%2011%2B-informational)
![Build](https://img.shields.io/badge/Build-javac%20%7C%20CLI-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

> Bộ bài tập và demo thực hành bao gồm Java (cú pháp cơ bản, xử lý chuỗi và mảng, lập trình hướng đối tượng), cùng với các nội dung về mạng và xử lý sự cố bằng Cisco Packet Tracer.

---

## 🖧 Mô Tả Đề Thi

- **Hình thức thi**: Thực hành trên máy – Cisco Packet Tracer hoặc GNS3  
- **Thời gian làm bài**: 180 phút.  
- **Cấu trúc bài thi**:
  Lập trình cơ bản (20%)  
  Lập trình hướng đối tượng (15%)  
  Mô phỏng mạng + cấu hình thiết bị (35%)  
  Sửa lỗi hệ thống mạng (30%)

## 📦 Cấu trúc thư mục chính

```text
knthcm/
├─ basic/               # Bài tập Java cơ bản (strings, arrays, functions,...)
├─ oop/                 # Bài tập Java OOP đầy đủ (Person, Student, Repository,...)
├─ network/             # Bài tập cơ bản về mạng Cisco Packet Tracer
└─ troubleshoot/        # Ghi chú xử lý lỗi / mẹo vặt Cisco Packet Tracer
```

---

## ⚙️ Yêu cầu môi trường

- **JDK 11+** (khuyến nghị JDK 21).
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
```

### Windows PowerShell

```powershell
cd knthcm
$files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac $files
```

> Nếu dùng **CMD** cổ điển, có thể dùng IDE (IntelliJ/Eclipse/VS Code) để build cho thuận tiện.

---

## 🤝 Đóng góp

- Fork repo, tạo **feature branch**, mở **Pull Request**.
- Code style: rõ ràng, tên biến/hàm có nghĩa, thêm bình luận khi cần.

---

## 📜 License

Phát hành theo giấy phép MIT. Xem file `LICENSE` (nếu có) hoặc thêm sau.

---

**Liên hệ / Góp ý:** vui lòng mở Issue trên GitHub hoặc để lại comment trong PR. Chúc bạn học tốt! 🚀
