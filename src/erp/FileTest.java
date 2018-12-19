package erp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

//import com.sun.rowset.CachedRowSetImpl;

public class FileTest {

   public static void main(String[] args) {
      
      PreparedStatement pstmt = null;
      Connection conn = null;
      ResultSet rs = null;
      
      String url = "jdbc:mysql://localhost:3306/erp";
      String uid = "root";
      String upw = "1234";
      String sql = "select * from test";
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url, uid, upw);
         pstmt = conn.prepareStatement(sql);
         
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
             System.out.println(rs.getString("id"));
             System.out.println(rs.getString("pw"));

             System.out.println("----------------------------");
          }
         
//         FileOutputStream out = new FileOutputStream("data.data");
//         ObjectOutputStream obt = new ObjectOutputStream(out);
//         
//         CachedRowSet row = new CachedRowSetImpl();
//         row.populate(rs);
//         
//         obt.writeObject(row);
//         fileLoad();

      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   
   static void fileLoad() {
      
      try {
         
         FileInputStream file = new FileInputStream("data.data");
         ObjectInputStream obt = new ObjectInputStream(file);
         
         ResultSet rs = (ResultSet) obt.readObject();
         
         while(rs.next()) {
            System.out.println(rs.getString("ISBN"));
            System.out.println(rs.getString("classification"));
            System.out.println(rs.getString("title"));
            System.out.println(rs.getString("publisher"));
            System.out.println(rs.getString("writer"));
            System.out.println(rs.getString("price"));      
            System.out.println("----------------------------");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }   
   }

}