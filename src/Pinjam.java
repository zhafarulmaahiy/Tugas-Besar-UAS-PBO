import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pinjam extends Peminjaman {
    public Pinjam(String idpemin, String namapeminjam, String idbuku, String namabuku){
        super(idpemin,namapeminjam,idbuku, namabuku);
        String url = "jdbc:mysql://localhost:3306/Perpus";
        String user = "root";
        String pass = "";
        String sql = "INSERT INTO Peminjaman (Tanggal, ID_Pinjam, Nama_Pinjam, ID_Buku, Nama_buku, Tanggal_Kembali) VALUES (?, ?, ?, ?, ?, ?)";
        Tanggal hari = new Tanggal();
        
        try (Connection konek = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement prep = konek.prepareStatement(sql);
            prep.setString(1, hari.Sekarang());
            prep.setString(2, idpemin);
            prep.setString(3, namapeminjam);
            prep.setString(4, idbuku);
            prep.setString(5, namabuku);
            prep.setString(6, hari.WaktuKembali());
            
            //==========================================================
            
            String sqlbuk = "SELECT Jumlah FROM Buku WHERE ID_Buku = ?";
            PreparedStatement prebuku = konek.prepareStatement(sqlbuk);
            prebuku.setString(1, idbuku);
                
            ResultSet resultSet = prebuku.executeQuery();
                
            int nilaiawal = 0;
            if (resultSet.next()) {
                nilaiawal = resultSet.getInt("Jumlah");
            }
            
            int baru = nilaiawal - 1;
            
            String sqlUpdate = "UPDATE Buku SET Jumlah = ? WHERE ID_Buku = ?";
            PreparedStatement preupdate = konek.prepareStatement(sqlUpdate);
            preupdate.setInt(1, baru);
            preupdate.setString(2, idbuku);
            

            int rowsUpdated = preupdate.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.print("1 ");
            }
            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("BUKU TELAH DIPINJAM");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
