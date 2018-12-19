package erp;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

public class OrderDAO {
	ArrayList<BookTotalDTO> books = new ArrayList<>();
	ArrayList<BurnHoDTO> books2 = new ArrayList<>();

	// 도서등록
	public void insert(OrderDTO dto) {

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/erp";
		String user = "root";
		String password = "1234";
		String sql = "insert into books_order values(null,null,?)";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getPublisher());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 출판사 삭제
	public void delete(String publisher) {

		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/erp";
		String user = "root";
		String password = "1234";
		String sql = "delete from books_order where publisher=?";
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);

			ps.setString(1, publisher);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// 책 아이템 수량 수정
	public void update(int quantity, String isbn) {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "update order_detail set quantity = ? where isbn=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			ps = conn.prepareStatement(sql);

			ps.setInt(1, quantity);
			ps.setString(2, isbn);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 발주리스트 전체보기
	public ArrayList<BookTotalDTO> SelectAll() {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select books.* ,books_order.no,books_order.TS from books_order,books where books_order. publisher=books.publisher";
		books = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				books.add(new BookTotalDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("no"),
						rs.getString("TS")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	// 발주 장기재고 리스트
	public ArrayList<OrderDTO> lostList(String date) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		ArrayList<OrderDTO> lostBooks = new ArrayList<>();

		DecimalFormat df = new DecimalFormat("00");

		int result = Integer.parseInt(date.substring(4, 6));
		System.out.println(date + " -> " + result);

		String num = "1";
		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from books_order where TS like '2018-" + num + "%'";
		books = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);

			for (int i = 1; i < result; i++) {
				num = "" + df.format(i);

				sql = "select * from books_order where TS like '2018-" + num + "%'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					lostBooks.add(new OrderDTO(rs.getString("publisher")));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lostBooks;
	}

	// 출판사별 책발주리스트
	public ArrayList<OrderDTO> catalogList(int no) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		String sql = "select * from books";
		books = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				books.add(new BookTotalDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("no"),
						rs.getString("TS")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 번호별로 리스트불러오기

	public ArrayList<BurnHoDTO> burnhoList(int no) {

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/erp";
		String uid = "root";
		String upw = "1234";
		// String sql = "select * from order_detail where no='" + no + "'";
		String sql2 = "select books. * ,order_detail.no ,order_detail.quantity from order_detail,books where order_detail.ISBN=books.ISBN";

		books = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql2);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				books2.add(new BurnHoDTO(rs.getString("ISBN"), rs.getString("classification"), rs.getString("title"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"), rs.getInt("no"),
						rs.getInt("quantity")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return books2;

	}

}
