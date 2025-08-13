package basic;

import java.util.*;
import java.math.BigInteger;

public class BasicNumberAnalysis {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { // tu dong dong scanner
            while (true) {
                printMenu();
                System.out.print("\n>> Chon chuc nang (0 de thoat): ");
                int choice = safeReadInt(sc);

                switch (choice) {
                    case 1 -> smallestDigit(sc); // Chu so nho nhat
                    case 2 -> largestDigit(sc); // Chu so lon nhat
                    case 3 -> toBinaryRecursion(sc); // N -> nhi phan (mang + de quy)
                    case 4 -> reverseNumber(sc); // Dao nguoc N
                    case 5 -> countEvenOddDigits(sc); // Dem chu so chan/le
                    case 6 -> digitSumAndRoot(sc); // Tong chu so + digital root
                    case 7 -> digitProductNonZero(sc); // Tich chu so (bo 0)
                    case 8 -> numberOfDigits(sc); // Dem so chu so
                    case 9 -> palindromeCheck(sc); // Kiem tra doi xung
                    case 10 -> primeCheck(sc); // Kiem tra nguyen to
                    case 11 -> primeFactorization(sc); // Phan tich thua so nguyen to
                    case 12 -> listPrimeDivisors(sc); // Liet ke cac uoc so nguyen to
                    case 13 -> listAllDivisors(sc); // Liet ke tat ca uoc so
                    case 14 -> countDivisors(sc); // Dem so luong uoc so d(N)
                    case 15 -> sumOfDivisors(sc); // Tong uoc so sigma(N)
                    case 16 -> classifyNumber(sc); // Hoan hao / du / thieu
                    case 17 -> eulerTotient(sc); // Phi Euler phi(N)
                    case 18 -> trailingZerosFactorial(sc); // So 0 o cuoi N!
                    case 19 -> v2Decompose(sc); // Bac 2 v2(N), N = 2^k * m
                    case 20 -> powerChecks(sc); // Kiem tra: pow of 2, square, cube, prime power
                    case 21 -> hammingWeight(sc); // Dem bit 1 (Hamming weight)
                    case 22 -> armstrongCheck(sc); // Kiem tra so Armstrong
                    case 23 -> harshadCheck(sc); // Kiem tra so Harshad
                    case 24 -> automorphicCheck(sc); // Kiem tra so Automorphic
                    case 25 -> baseConversion(sc); // Doi co so (2..16)
                    case 0 -> {
                        System.out.println("Thoat chuong trinh.");
                        return;
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    // ====== MENU ======
    private static void printMenu() {
        System.out.println("\n===== MENU PHAN TICH SO N =====");
        System.out.println("1.  Chu so nho nhat cua N");
        System.out.println("2.  Chu so lon nhat cua N");
        System.out.println("3.  N -> Nhi phan (mang + de quy)");
        System.out.println("4.  Dao nguoc so N");
        System.out.println("5.  Dem chu so chan / le cua N");
        System.out.println("6.  Tong chu so va digital root");
        System.out.println("7.  Tich chu so (bo cac chu so 0)");
        System.out.println("8.  Dem so chu so cua N");
        System.out.println("9.  Kiem tra N co doi xung (palindrome) khong");
        System.out.println("10. Kiem tra N co la so nguyen to khong");
        System.out.println("11. Phan tich thua so nguyen to (dang p^e)");
        System.out.println("12. Liet ke cac uoc so nguyen to cua N");
        System.out.println("13. Liet ke tat ca uoc so cua N (tang dan)");
        System.out.println("14. Dem so luong uoc so d(N)");
        System.out.println("15. Tong tat ca uoc so sigma(N)");
        System.out.println("16. Phan loai: hoan hao / du / thieu");
        System.out.println("17. Phi Euler phi(N)");
        System.out.println("18. So 0 o cuoi N!");
        System.out.println("19. v2(N) va phan tich N = 2^k * m (m le)");
        System.out.println("20. Kiem tra: power of 2, perfect square, perfect cube, prime power");
        System.out.println("21. Dem so bit 1 trong N (Hamming weight)");
        System.out.println("22. Kiem tra so Armstrong");
        System.out.println("23. Kiem tra so Harshad (chia het cho tong chu so)");
        System.out.println("24. Kiem tra so Automorphic (N^2 ket thuc bang N)");
        System.out.println("25. Doi co so N sang base b (2..16)");
        System.out.println("0.  Thoat");
    }

    // ====== TIEN ICH NHAP ======
    private static int safeReadInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Nhap lai so nguyen: ");
        }
        int x = sc.nextInt();
        sc.nextLine();
        return x;
    }

    private static long safeReadLong(Scanner sc) {
        while (!sc.hasNextLong()) {
            sc.nextLine();
            System.out.print("Nhap lai so nguyen (long): ");
        }
        long x = sc.nextLong();
        sc.nextLine();
        return x;
    }

    private static long readLongInRange(Scanner sc, String prompt, long min, long max) {
        while (true) {
            System.out.print(prompt);
            long v = safeReadLong(sc);
            if (v >= min && v <= max)
                return v;
            System.out.println("Gia tri phai trong [" + min + ", " + max + "].");
        }
    }

    private static int digitsCountNonNegative(long n) {
        if (n == 0)
            return 1;
        int c = 0;
        while (n > 0) {
            c++;
            n /= 10;
        }
        return c;
    }

    // ====== 1) CHU SO NHO NHAT ======
    private static void smallestDigit(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        if (n == 0) {
            System.out.println("Chu so nho nhat: 0");
            return;
        }
        int mn = 9;
        while (n > 0) {
            int d = (int) (n % 10);
            if (d < mn)
                mn = d;
            n /= 10;
        }
        System.out.println("Chu so nho nhat: " + mn);
    }

    // ====== 2) CHU SO LON NHAT ======
    private static void largestDigit(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        int mx = 0;
        if (n == 0)
            mx = 0;
        while (n > 0) {
            int d = (int) (n % 10);
            if (d > mx)
                mx = d;
            n /= 10;
        }
        System.out.println("Chu so lon nhat: " + mx);
    }

    // ====== 3) N -> NHI PHAN (DE QUY + MANG) ======
    private static void toBinaryRecursion(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        int[] bits = new int[64]; // du cho long
        int len = toBinRec(n, bits, 0); // luu LSB -> MSB
        System.out.print("Nhi phan (de quy): ");
        for (int i = len - 1; i >= 0; i--)
            System.out.print(bits[i]);
        System.out.println();
    }

    private static int toBinRec(long n, int[] bits, int idx) {
        if (n < 2) {
            bits[idx] = (int) n;
            return idx + 1;
        }
        bits[idx] = (int) (n % 2);
        return toBinRec(n / 2, bits, idx + 1);
    }

    // ====== 4) DAO NGUOC N ======
    private static void reverseNumber(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        System.out.println("So dao nguoc: " + rev);
    }

    // ====== 5) DEM CHU SO CHAN / LE ======
    private static void countEvenOddDigits(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        if (n == 0) {
            System.out.println("Chan: 1, Le: 0");
            return;
        }
        int even = 0, odd = 0;
        while (n > 0) {
            int d = (int) (n % 10);
            if ((d & 1) == 0)
                even++;
            else
                odd++;
            n /= 10;
        }
        System.out.println("Chan: " + even + ", Le: " + odd);
    }

    // ====== 6) TONG CHU SO + DIGITAL ROOT ======
    private static void digitSumAndRoot(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        long sum = 0, t = n;
        do {
            sum += t % 10;
            t /= 10;
        } while (t > 0);
        long digitalRoot = (n == 0) ? 0 : 1 + (n - 1) % 9;
        System.out.println("Tong chu so = " + sum + ", Digital root = " + digitalRoot);
    }

    // ====== 7) TICH CHU SO (BO 0) ======
    private static void digitProductNonZero(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        if (n == 0) {
            System.out.println("Tich (bo 0) = 0");
            return;
        }
        long prod = 1;
        boolean found = false;
        while (n > 0) {
            int d = (int) (n % 10);
            if (d != 0) {
                prod *= d;
                found = true;
            }
            n /= 10;
        }
        System.out.println("Tich (bo 0) = " + (found ? prod : 0));
    }

    // ====== 8) DEM SO CHU SO ======
    private static void numberOfDigits(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        System.out.println("So chu so: " + digitsCountNonNegative(n));
    }

    // ====== 9) PALINDROME ======
    private static void palindromeCheck(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        long t = n, rev = 0;
        while (t > 0) {
            rev = rev * 10 + (t % 10);
            t /= 10;
        }
        System.out.println((rev == n) ? "YES" : "NO");
    }

    // ====== 10) NGUYEN TO ======
    private static void primeCheck(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        System.out.println(isPrime(n) ? "YES" : "NO");
    }

    private static boolean isPrime(long n) {
        if (n < 2)
            return false;
        if (n % 2 == 0)
            return n == 2;
        for (long i = 3; i <= n / i; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    // ====== 11) PHAN TICH THUA SO NGUYEN TO ======
    private static void primeFactorization(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=2): ", 2, Long.MAX_VALUE);
        Map<Long, Integer> map = factorize(n);
        System.out.print(n + " = ");
        boolean first = true;
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            if (!first)
                System.out.print(" * ");
            System.out.print(e.getKey());
            if (e.getValue() > 1)
                System.out.print("^" + e.getValue());
            first = false;
        }
        System.out.println();
    }

    private static Map<Long, Integer> factorize(long n) {
        Map<Long, Integer> map = new LinkedHashMap<>();
        long t = n;
        for (long p = 2; p <= t / p; p += (p == 2 ? 1 : 2)) {
            while (t % p == 0) {
                map.put(p, map.getOrDefault(p, 0) + 1);
                t /= p;
            }
        }
        if (t > 1)
            map.put(t, map.getOrDefault(t, 0) + 1);
        return map;
    }

    // ====== 12) LIET KE UOC SO NGUYEN TO ======
    private static void listPrimeDivisors(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=2): ", 2, Long.MAX_VALUE);
        Map<Long, Integer> map = factorize(n);
        System.out.print("Uoc so nguyen to: ");
        boolean first = true;
        for (long p : map.keySet()) {
            if (!first)
                System.out.print(" ");
            System.out.print(p);
            first = false;
        }
        System.out.println();
    }

    // ====== 13) LIET KE TAT CA UOC SO ======
    private static void listAllDivisors(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=1): ", 1, Long.MAX_VALUE);
        TreeSet<Long> set = new TreeSet<>();
        for (long i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        System.out.print("Uoc so: ");
        for (Long v : set)
            System.out.print(v + " ");
        System.out.println();
    }

    // ====== 14) DEM SO LUONG UOC SO d(N) ======
    private static void countDivisors(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=1): ", 1, Long.MAX_VALUE);
        Map<Long, Integer> map = factorize(n);
        long d = 1;
        for (int e : map.values())
            d *= (e + 1);
        System.out.println("d(N) = " + d);
    }

    // ====== 15) TONG UOC SO sigma(N) ======
    private static void sumOfDivisors(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=1): ", 1, Long.MAX_VALUE);
        Map<Long, Integer> map = factorize(n);
        BigInteger sigma = BigInteger.ONE;
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            BigInteger p = BigInteger.valueOf(e.getKey());
            int k = e.getValue();
            // (p^(k+1) - 1) / (p - 1)
            BigInteger num = p.pow(k + 1).subtract(BigInteger.ONE);
            BigInteger den = p.subtract(BigInteger.ONE);
            sigma = sigma.multiply(num.divide(den));
        }
        System.out.println("sigma(N) = " + sigma);
    }

    // ====== 16) PHAN LOAI HOAN HAO / DU / THIEU ======
    private static void classifyNumber(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=1): ", 1, Long.MAX_VALUE);
        // s(N) = sigma(N) - N
        Map<Long, Integer> map = factorize(n);
        BigInteger sigma = BigInteger.ONE;
        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            BigInteger p = BigInteger.valueOf(e.getKey());
            int k = e.getValue();
            BigInteger num = p.pow(k + 1).subtract(BigInteger.ONE);
            BigInteger den = p.subtract(BigInteger.ONE);
            sigma = sigma.multiply(num.divide(den));
        }
        BigInteger proper = sigma.subtract(BigInteger.valueOf(n));
        if (proper.equals(BigInteger.valueOf(n))) {
            System.out.println("Perfect (hoan hao)");
        } else if (proper.compareTo(BigInteger.valueOf(n)) > 0) {
            System.out.println("Abundant (du)");
        } else {
            System.out.println("Deficient (thieu)");
        }
    }

    // ====== 17) PHI EULER phi(N) ======
    private static void eulerTotient(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=1): ", 1, Long.MAX_VALUE);
        Map<Long, Integer> map = factorize(n);
        BigInteger phi = BigInteger.valueOf(n);
        for (long p : map.keySet()) {
            phi = phi.divide(BigInteger.valueOf(p)).multiply(BigInteger.valueOf(p - 1));
        }
        System.out.println("phi(N) = " + phi);
    }

    // ====== 18) SO 0 O CUOI N! ======
    private static void trailingZerosFactorial(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        long ans = 0, t = n;
        while (t > 0) {
            t /= 5;
            ans += t;
        }
        System.out.println("So 0 o cuoi N! = " + ans);
    }

    // ====== 19) v2(N) va N = 2^k * m ======
    private static void v2Decompose(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=1): ", 1, Long.MAX_VALUE);
        int k = 0;
        long t = n;
        while ((t & 1) == 0) {
            k++;
            t >>= 1;
        }
        System.out.println("v2(N) = " + k + ", N = 2^" + k + " * " + t + " (m le)");
    }

    // ====== 20) POWER CHECKS ======
    private static void powerChecks(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);

        boolean pow2 = (n > 0) && ((n & (n - 1)) == 0);
        long s = (long) Math.sqrt(n);
        boolean square = (s * s == n);
        long c = Math.round(Math.cbrt(n));
        boolean cube = (c * c * c == n);

        boolean primePower = false;
        if (n >= 2) {
            Map<Long, Integer> map = factorize(n);
            primePower = (map.size() == 1);
        }

        System.out.println("Power of 2: " + (pow2 ? "YES" : "NO"));
        System.out.println("Perfect square: " + (square ? "YES" : "NO"));
        System.out.println("Perfect cube: " + (cube ? "YES" : "NO"));
        System.out.println("Prime power p^k: " + (primePower ? "YES" : "NO"));
    }

    // ====== 21) HAMMING WEIGHT ======
    private static void hammingWeight(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1L);
            n >>>= 1;
        }
        System.out.println("So bit 1 = " + cnt);
    }

    // ====== 22) ARMSTRONG ======
    private static void armstrongCheck(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        int k = digitsCountNonNegative(n);
        long sum = 0, t = n;
        do {
            int d = (int) (t % 10);
            sum += intPow(d, k);
            t /= 10;
        } while (t > 0);
        System.out.println((sum == n) ? "YES" : "NO");
    }

    private static long intPow(int a, int e) {
        long r = 1;
        for (int i = 0; i < e; i++)
            r *= a;
        return r;
    }

    // ====== 23) HARSHAD ======
    private static void harshadCheck(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        if (n == 0) {
            System.out.println("YES");
            return;
        } // 0 chia het cho tong chu so 0 (dinh nghia dac biet co the tranh dung)
        long sum = 0, t = n;
        do {
            sum += t % 10;
            t /= 10;
        } while (t > 0);
        System.out.println((sum != 0 && n % sum == 0) ? "YES" : "NO");
    }

    // ====== 24) AUTOMORPHIC ======
    private static void automorphicCheck(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        int k = digitsCountNonNegative(n);
        BigInteger mod = BigInteger.TEN.pow(k);
        BigInteger sq = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n));
        boolean ok = sq.mod(mod).equals(BigInteger.valueOf(n));
        System.out.println(ok ? "YES" : "NO");
    }

    // ====== 25) DOI CO SO (2..16) ======
    private static void baseConversion(Scanner sc) {
        long n = readLongInRange(sc, "Nhap N (>=0): ", 0, Long.MAX_VALUE);
        int b = (int) readLongInRange(sc, "Nhap base b (2..16): ", 2, 16);
        if (n == 0) {
            System.out.println("0");
            return;
        }
        char[] map = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();
        long t = n;
        while (t > 0) {
            int r = (int) (t % b);
            sb.append(map[r]);
            t /= b;
        }
        System.out.println("N trong co so " + b + ": " + sb.reverse());
    }
}
