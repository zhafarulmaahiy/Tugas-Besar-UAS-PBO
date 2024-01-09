import java.sql.*;


public class Tambah extends Buku {
    public Tambah(){

    }
    public Tambah(String idbuku, String namabuku, int jumlah){
        super(namabuku, idbuku, jumlah);
        String url = "jdbc:mysql://localhost:3306/Perpus";
        String user = "root";
        String pass = "";

        String sql = "INSERT INTO Buku (ID_Buku, Nama_Buku, Jumlah) VALUES (?, ?, ?)";

        try (
            Connection konek = DriverManager.getConnection(url, user, pass);
            PreparedStatement prep = konek.prepareStatement(sql)
        ) {
            prep.setString(1, idbuku);
            prep.setString(2, namabuku);
            prep.setInt(3, jumlah);

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.print("BUKU BERHASIL DITAMBAHKAN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
