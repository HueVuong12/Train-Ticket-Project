package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	
	ArrayList<KhachHang> dsKH;
	
	public KhachHang_DAO(){ 
		dsKH = new ArrayList<KhachHang>();  
	}
	
	public ArrayList<KhachHang> docTuBang()  { 
	    try { 
	    	Connection con = ConnectDB.getInstance().getConnection(); 
	    	String sql = "Select * from KhachHang"; 
	    	Statement statement = con.createStatement(); 
	    	// Thực thi câu lệnh SQL trả về đối tượng ResultSet. 
	    	ResultSet rs = statement.executeQuery(sql); 
	    	// Duyệt trên kết quả trả về. 
	    	while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp. 
	    		String maKH = rs.getString("maKH"); 
	    		String tenKH = rs.getString("tenKH"); 
	    		String email = rs.getString("email");
	    		String sdt = rs.getString("sdt"); 
	    		String cccd = rs.getString("cccd"); 

	    		KhachHang kh = new KhachHang(maKH, tenKH, email, sdt, cccd);
	    		
	    		dsKH.add(kh);
	       } 
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	       // Đóng kết nối 
	    } 
	    return dsKH; 
	}
	
	public KhachHang getKHTheoMaKH(String mKH) { 
		Connection con = ConnectDB.getInstance().getConnection(); 
		PreparedStatement stmt =null; 
		KhachHang kh = null;
		
		try {       
			String sql = "Select * from KhachHang where maKH = ?"; 
			stmt = con.prepareStatement(sql); 
			stmt.setString(1, mKH); 
			ResultSet rs = stmt.executeQuery(); 
			
			if (rs.next()) {
				String maKH = rs.getString("maKH"); 
	    		String tenKH = rs.getString("tenKH"); 
	    		String email = rs.getString("email");
	    		String sdt = rs.getString("sdt"); 
	    		String cccd = rs.getString("cccd");

	    		kh = new KhachHang(maKH, tenKH, email, sdt, cccd);
			} 
		} catch (SQLException e) { 
			e.printStackTrace();     
		} 

		return kh; 
	} 
	
	public boolean create(KhachHang p) { 
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null; 
		int n = 0; 
		try { 
			stmt = con.prepareStatement("insert into KhachHang values(?, ?, ?, ?, ?)"); 
			stmt.setString(1,p.getMaKH());
			stmt.setString(2,p.getTenKH());
			stmt.setString(3,p.getEmail());
			stmt.setString(4,p.getSdt());
			stmt.setString(5,p.getCccd());

			
			n = stmt.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		}
		
		return n > 0;
	} 
	//U: Update 
	public boolean update(KhachHang p) { 
		Connection con = ConnectDB.getInstance().getConnection(); 
		PreparedStatement stmt = null; 
		int n = 0; 
		try { 
			stmt = con.prepareStatement("update KhachHang set tenKH = ?, email = ?, sdt = ?, cccd = ? where maKH = ?"); 
			stmt.setString(1,p.getTenKH());
			stmt.setString(2,p.getEmail());
			stmt.setString(3,p.getSdt());
			stmt.setString(3,p.getCccd());
			stmt.setString(6,p.getMaKH());
		     
		    n = stmt.executeUpdate(); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		
		return n > 0;
	} 
		   
//	//D: Delete 
//	public boolean delete(String maKH) { 
//		Connection con = ConnectDB.getInstance().getConnection(); 
//		PreparedStatement stmt = null; 
//		int n = 0; 
//		try { 
//			stmt = con.prepareStatement("delete from KhachHang where maKH = ?"); 
//		    stmt.setString(1, maKH); 
//		    n = stmt.executeUpdate(); 
//		} catch (SQLException e) { 
//			e.printStackTrace(); 
//		} 
//		
//		return n > 0;
//	}
	
	public void reset() {
		dsKH.removeAll(dsKH);
	}
	
	public KhachHang getKhachHangByTen(String tenKhachHang){
		KhachHang khachHang = null;
		
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT * FROM KhachHang WHERE [tenKH] = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenKhachHang);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String maKH = rs.getString("maKH"); 
	    		String tenKH = rs.getString("tenKH"); 
	    		String email = rs.getString("email");
	    		String sdt = rs.getString("sdt"); 
	    		String cccd = rs.getString("cccd"); 
	        	khachHang = new KhachHang(maKH, tenKH, email, sdt, cccd);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return khachHang;
	}
	
	public KhachHang getKhachhangcapByma(String maKhachHang){
		KhachHang khachHang = null;
		
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectDB.getConnection();
			String sql = "SELECT * FROM KhachHang WHERE [maKH] = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKhachHang);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String maKH = rs.getString("maKH"); 
	    		String tenKH = rs.getString("tenKH"); 
	    		String email = rs.getString("email");
	    		String sdt = rs.getString("sdt"); 
	    		String cccd = rs.getString("cccd"); 
				khachHang=new KhachHang(maKH, tenKH, email, sdt, cccd);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return khachHang;
	}
}