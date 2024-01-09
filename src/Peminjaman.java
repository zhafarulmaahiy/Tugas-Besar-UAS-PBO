import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Peminjaman implements Perpus {
    protected String namabuku,idbuku, namapeminjam, idpeminjam;

    public Peminjaman(){}
    public Peminjaman(String b){}
    public Peminjaman(String h, String g){}
    public Peminjaman(String i, String b, String e, String f){}

    @Override
    public void Tampil(){
        String url = "jdbc:mysql://localhost:3306/Perpus";
        String user = "root"; 
        String pass = "";
        try(Connection konek = DriverManager.getConnection(url, user, pass)) {
            Statement state = konek.createStatement();
            String sql = """
                    SELECT * FROM Peminjaman
                    """;
            ResultSet set = state.executeQuery(sql);
            ResultSetMetaData meta = set.getMetaData();
            int hitung = meta.getColumnCount();

            for (int i = 1; i <= hitung; i++) {
                if (i==1) {
                    System.out.print(meta.getColumnName(i)+ "\t\t\t\t||");
                }else if(i==6){
                    System.out.print(meta.getColumnName(i)+ "\t\t||");
                } else {
                    System.out.print(meta.getColumnName(i)+ "\t||");
                }
            }
            System.out.println();
            while(set.next()) {
                for (int i = 1; i <= hitung; i++) {
                    if ((i==1) || (i==5)) {
                        System.out.print(set.getString(i) + "\t||");
                    }else if(i==6){
                        System.out.print(set.getString(i)+"\t||");
                    } else {
                        System.out.print(set.getString(i) + "\t\t||");
                    }
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
