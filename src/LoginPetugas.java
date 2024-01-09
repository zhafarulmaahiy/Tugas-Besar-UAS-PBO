import java.util.HashMap;
import java.util.Scanner;

public class LoginPetugas {

    public void login(){
        
        HashMap<String, String> pegawai = new HashMap<>();
        Scanner inex = new Scanner(System.in);
        boolean lop = true, out = false;
        pegawai.put("Ipin", "ayamgoyeng");
        pegawai.put("MeiMei", "#haia#");
        pegawai.put("Jarjit", "Susanti");
        do {
            System.out.println();
            System.out.println("============LOGIN PEGAWAI=============");
            System.out.print("Masukkan username: ");
            String nama = inex.nextLine();
            
            System.out.print("Masukkan password: ");
            String sandi = inex.nextLine();

            if (pegawai.containsKey(nama) && pegawai.get(nama).equals(sandi)) {
                System.out.println("Login Berhasil! Selamat Datang, " + nama + "!");
                lop = out;
            } else {
                System.out.println("USERNAME ATAU PASSWORD SALAH");
            }
            
        } while (lop);
    }
}

