import java.util.Scanner;

public class PerpusKita {
    public static void main(String[] args) throws Exception {
        boolean setup=true, setup1=false;
        String nabok,idbok,nape,idpe;
        int jumbok,jumpin;
        Scanner in = new Scanner(System.in);
        Buku book = new Buku();
        Peminjaman pinjam = new Peminjaman();
        Tanggal day = new Tanggal();
        System.out.println("------SELAMAT DATANG DI PERPUSKITA------");
        System.out.println("====================================");
        day.Tampil();
        LoginPetugas log = new LoginPetugas();
        log.login();
        try{
            do {
                System.out.println("");
                System.out.println("PILIHAN MENU UTAMA :\n1. Edit Buku\n2. Peminjaman Buku\n3. Exit");
                System.out.print("Masukkan pilihan(1/2/3) : ");
                int select = in.nextInt();
                in.nextLine();
                if (select == 1) { // ============================EDIT BUKU PERPUS
                    boolean setup2=true, setup3=false;
                    do {
                        setup2 = true;
                        System.out.println("");
                        System.out.println("EDIT BUKU :\n1. Tambah Buku\n2. Hapus Buku\n3. Edit Buku\n4. Tabel Buku\n5. Kembali");
                        System.out.print("Masukkan pilihan(1/2/3/4/5) : ");
                        select = in.nextInt();
                        in.nextLine();
                        if (select == 1) {
                            book.Tampil();
                            System.out.println();
                            System.out.println("=== MENAMBAHKAN BUKU ===");
                            System.out.print("Masukkan ID Buku\t: ");
                            idbok= in.nextLine();
                            System.out.print("Masukkan Nama Buku\t: ");
                            nabok = in.nextLine();
                            System.out.print("Masukkan Jumlah Buku\t: ");
                            jumbok = in.nextInt();
                            in.nextLine();
                            Tambah ples = new Tambah(idbok,nabok,jumbok);
                        }else if(select == 2) {
                            book.Tampil();
                            System.out.println();
                            System.out.println("=== MENGHAPUS BUKU ===");
                            System.out.print("Masukkan ID Buku\t: ");
                            idbok= in.nextLine();
                            Hapus ples = new Hapus(idbok);
                        }else if (select == 3) {
                            book.Tampil();
                            System.out.println();
                            System.out.println("=== EDIT DATA BUKU ===");
                            System.out.print("Masukkan ID Buku\t: ");
                            idbok= in.nextLine();
                            System.out.print("Masukkan Nama Buku\t: ");
                            nabok = in.nextLine();
                            System.out.print("Masukkan Jumlah Buku\t: ");
                            jumbok=in.nextInt();
                            in.nextLine();
                            Update ples = new Update(idbok,nabok,jumbok);
                        }else if (select == 4){
                            System.out.println();
                            System.out.println("=== DAFTAR BUKU ===");
                            book.Tampil();
                        }else if(select == 5){
                            setup2 = setup3;
                        } else {
                            System.out.println("PILIHAN TIDAK TERSEDIA");
                        }
                        System.out.println();
                    } while (setup2);
                }else if(select == 2){ //=============================PEMIJAMAN BUKU PERPUS
                    boolean setup2=true, setup3=false;
                    do {
                        setup2 = true;
                        System.out.println("");
                        System.out.println("PEMINJAMAN :\n1. Peminjaman Buku\n2. Pengembalian Buku\n3. Daftar Buku\n4. Daftar Peminjaman\n5. Kembali");
                        System.out.print("Masukkan pilihan(1/2/3/4/5) : ");
                        select = in.nextInt();
                        in.nextLine();
                        if (select == 1) { //==========================PEMINJAMAN
                            book.Tampil();
                            System.out.println();
                            System.out.println("=== PEMINJAMAN BUKU ===");
                            System.out.print("Masukkan ID Peminjam\t: ");
                            idpe= in.nextLine();
                            System.out.print("Masukkan Nama Peminjam\t: ");
                            nape = in.nextLine();
                            System.out.print("Masukkan ID Buku\t: ");
                            idbok = in.nextLine();
                            System.out.print("Masukkan Nama Buku\t: ");
                            nabok = in.nextLine();
                            Pinjam pin = new Pinjam(idpe, nape, idbok, nabok);
                        }else if(select == 2) { //====================PENGEMBALIAN
                            pinjam.Tampil();
                            System.out.println();
                            System.out.println("=== PENGEMBALIAN BUKU ===");
                            System.out.print("Masukkan ID Peminjam\t: ");
                            idpe = in.nextLine();
                            System.out.print("Masukkan ID Buku\t: ");
                            idbok = in.nextLine();
                            Kembali er = new Kembali(idpe,idbok);
                        }else if (select == 3) { //====================TABEL BUKU
                            System.out.println();
                            System.out.println("=== DAFTAR BUKU ===");
                            book.Tampil();
                        }else if (select == 4){
                            System.out.println();
                            System.out.println("=== DAFTAR PEMINJAMAN ===");
                            pinjam.Tampil();
                        }else if(select == 5){
                            setup2 = setup3;
                        } else {
                            System.out.println("PILIHAN TIDAK TERSEDIA");
                        }
                        System.out.println();
                    } while (setup2);
                }else if(select == 3){
                    setup = setup1;
                } else {
                    System.out.println("PILIHAN TIDAK TERSEDIA");
                }
            } while (setup);
            
        } catch (Exception e) {
            System.out.println("JANGAN MASUKKAN HURUF");
            // TODO: handle exception
        }
        System.out.println("APLIKASI TELAH DITUTUP");
        in.close();
    }
}
