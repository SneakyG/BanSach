package sneakyg.giang.model;

import java.util.Date;

public class NhanVien extends KhachHang {

	private double luong;
	private Date ngayVL;
	
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public Date getNgayVL() {
		return ngayVL;
	}
	public void setNgayVL(Date ngayVL) {
		this.ngayVL = ngayVL;
	}
	
}
