import java.sql.*;

public class Update extends Buku {
    public Update(String idbuku, String namabuku, int jumlah){
        super(idbuku, namabuku, jumlah);
        String url = "jdbc:mysql://localhost:3306/Perpus";
        String user = "root";
        String pass = "";
        String sql = "UPDATE Buku SET Nama_Buku = ?, Jumlah = ? WHERE ID_Buku = ?";
        
        try (
            Connection konek = DriverManager.getConnection(url, user, pass);
            PreparedStatement prep = konek.prepareStatement(sql);
            ) {
                
            prep.setString(1, namabuku);
            prep.setInt(2, jumlah);
            prep.setString(3, idbuku);

            int rowsUpdated = prep.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("DATA BUKU TELAH DIUBAH");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
