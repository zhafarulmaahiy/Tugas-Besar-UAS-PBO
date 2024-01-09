import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hapus extends Buku {
    public Hapus(String idbuku){
        super(idbuku);
        String url = "jdbc:mysql://localhost:3306/Perpus";
        String user = "root";
        String pass = "";
        String sql = "DELETE FROM Buku WHERE ID_Buku = ?";
        
        try (
            Connection konek = DriverManager.getConnection(url, user, pass);
            PreparedStatement prep = konek.prepareStatement(sql)
            ) {
            prep.setString(1, idbuku);

            int hapusnotif = prep.executeUpdate();
            if (hapusnotif > 0) {
                System.out.println("BUKU BERHASIL DIHAPUS");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

