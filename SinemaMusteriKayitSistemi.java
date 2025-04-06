import java.util.Scanner;

public class SinemaMusteriKayitSistemi {
    static int maxf = 10;
    static int maxm = 20;

    static String[] filmadi = new String[maxf];
    static int[] filmsure = new int[maxf];
    static String[] filmtur = new String[maxf];

    static String[] musteriad = new String[maxm];
    static String[] musteriemail = new String[maxm];

    static String[][] biletler = new String[maxm][maxf];

    static int filmler = 0;
    static int musteriler = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\nLutfen yapmak istediginiz islemi tuslayiniz; ");
            System.out.println("\n1 - Film Ekleme");
            System.out.println("\n2 - Musteri Ekleme");
            System.out.println("\n3 - Bilet Kayit");
            System.out.println("\n4 - Bilet Listeleme");
            System.out.println("\n5 - Cikis Yapmak");
            System.out.print("\nHangi islemi yapmak istersiniz tuslayiniz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    filmEkle(scanner);
                    break;
                case 2:
                    musteriEkle(scanner);
                    break;
                case 3:
                    biletKayit(scanner);
                    break;
                case 4:
                    biletleriListele();
                    break;
                case 5:
                    System.out.println("İyi günler dileriz.");
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        } while (secim != 5);

        scanner.close();
    }

    static void filmEkle(Scanner scanner) {
        if (filmler < maxf) {
            System.out.print("\nFilm adı: ");
            filmadi[filmler] = scanner.nextLine();
            System.out.print("Film süresi (dakika): ");
            filmsure[filmler] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Film türü: ");
            filmtur[filmler] = scanner.nextLine();

            filmler++;
            System.out.println("\nFilm başarıyla eklendi.");
        } else {
            System.out.println("\nDaha fazla film ekleyemezsiniz.");
        }
    }

    static void musteriEkle(Scanner scanner) {
        if (musteriler < maxm) {
            System.out.print("\nMüşteri adı: ");
            musteriad[musteriler] = scanner.nextLine();

            System.out.print("Müşteri email adresi: ");
            musteriemail[musteriler] = scanner.nextLine();
            musteriler++;

            System.out.println("\nMüşteri başarıyla eklendi.");
        } else {
            System.out.println("\nDaha fazla müşteri ekleyemezsiniz.");
        }
    }

    static void biletKayit(Scanner scanner) {
        if (musteriler == 0 || filmler == 0) {
            System.out.println("\nLütfen önce müşteri ve film ekleyin.");
            return;
        }

        System.out.println("\nMevcut müşteriler:");
        for (int i = 0; i < musteriler; i++) {
            System.out.println(i + 1 + ". " + musteriad[i] + " - " + musteriemail[i]);
        }

        System.out.print("\nBir müşteri seçiniz (1-" + musteriler + "): ");
        int musterisecimi = scanner.nextInt() - 1;
        scanner.nextLine();

        if (musterisecimi < 0 || musterisecimi >= musteriler) {
            System.out.println("\nGeçersiz seçim! Lütfen tekrar deneyin.");
            return;
        }

        System.out.println("\nMevcut filmler:");
        for (int i = 0; i < filmler; i++) {
            System.out.println(i + 1 + ". " + filmadi[i] + " - " + filmsure[i] + " dakika - Tür: " + filmtur[i]);
        }

        System.out.print("\nBir film seçin (1-" + filmler + "): ");
        int filmsecimi = scanner.nextInt() - 1;
        scanner.nextLine();

        if (filmsecimi < 0 || filmsecimi >= filmler) {
            System.out.println("\nGeçersiz seçim! Lütfen tekrar deneyin.");
            return;
        }

        biletler[musterisecimi][filmsecimi] = filmadi[filmsecimi];
        System.out.println("\nBiletiniz başarıyla onaylanmıştır.");
    }

    static void biletleriListele() {
        for (int i = 0; i < musteriler; i++) {
            System.out.println("\nMüşteri: " + musteriad[i]);
            System.out.println("Email: " + musteriemail[i]);
            System.out.println("İzlediği filmler:");

            int sayac = 0;

            for (int j = 0; j < filmler; j++) {
                if (biletler[i][j] != null) {
                    System.out.println("- " + biletler[i][j]);
                    sayac++;
                }
            }

            if (sayac == 0) {
                System.out.println("Hiç film yok.");
            }
        }
    }
}