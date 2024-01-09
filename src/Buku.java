import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class Buku implements Perpus{
    protected String namabuku,idbuku;
    protected int jumlah;
    String url = "jdbc:mysql://localhost:3306/Perpus"; // Ganti dengan URL database Anda
    String user = "root"; // Ganti dengan username database Anda
    String pass = "";

    public Buku(){}
    public Buku(String i, String b, int c){}
    public Buku(String b){}
    @Override
    public void Tampil(){
        try(Connection konek = DriverManager.getConnection(url, user, pass)) {
            Statement state = konek.createStatement();
            String sql = """
                    SELECT * FROM Buku
                    """;
            ResultSet set = state.executeQuery(sql);
            ResultSetMetaData meta = set.getMetaData();
            int hitung = meta.getColumnCount();

            for (int i = 1; i <= hitung; i++) {
                if (i == 2) {
                    System.out.print(meta.getColumnName(i)+ "\t||");
                }else{
                    System.out.print(meta.getColumnName(i)+ "\t\t||");
                }
            }
            System.out.println();
            while(set.next()) {
                for (int i = 1; i <= hitung; i++) {
                    System.out.print(set.getString(i) + "\t\t||");
                }
                System.out.println();
            }

            set.close();
            state.close();
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

}
