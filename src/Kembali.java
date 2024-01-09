import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kembali extends Peminjaman {
    public Kembali(String idpeminjam, String idbuku){
        super(idpeminjam, idbuku);
        String url = "jdbc:mysql://localhost:3306/Perpus";
        String user = "root";
        String pass = "";
        String sql = "DELETE FROM Peminjaman WHERE ID_Pinjam = ?";
        
        try (
            Connection konek = DriverManager.getConnection(url, user, pass);
            PreparedStatement prep = konek.prepareStatement(sql)
            ) {
            prep.setString(1, idpeminjam);

            
            String sqlbuk = "SELECT Jumlah FROM Buku WHERE ID_Buku = ?";
            PreparedStatement prebuku = konek.prepareStatement(sqlbuk);
            prebuku.setString(1, idbuku);
            
            ResultSet resultSet = prebuku.executeQuery();
            
            int nilaiawal = 0;
            if (resultSet.next()) {
                nilaiawal = resultSet.getInt("Jumlah");
            }
            
            int baru = nilaiawal + 1;
            
            String sqlUpdate = "UPDATE Buku SET Jumlah = ? WHERE ID_Buku = ?";
            PreparedStatement preupdate = konek.prepareStatement(sqlUpdate);
            preupdate.setInt(1, baru);
            preupdate.setString(2, idbuku);
            
            int rowsUpdated = preupdate.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.print("1 ");
            }
            int hapusnotif = prep.executeUpdate();
            if (hapusnotif > 0) {
                System.out.println("BUKU TELAH DIKEMBALIKAN");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
