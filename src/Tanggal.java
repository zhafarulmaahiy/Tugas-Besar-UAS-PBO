import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tanggal implements Perpus {

    @Override
    public void Tampil(){
        LocalDate sekarang = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        String tanggalFormat = sekarang.format(formatter);
        System.out.println("-------"+tanggalFormat+"--------");
    }

    public String WaktuKembali(){
        LocalDate sekarang = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        String tanggalFormat = sekarang.format(formatter);
        LocalDate tambah = sekarang.plusDays(7);
        String fortmat = tambah.format(formatter);
        return fortmat;
    }
    public String Sekarang(){
        LocalDate sekarang = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        String hasil = sekarang.format(formatter);
        return hasil;
    }
}
