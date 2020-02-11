package sneakyg.giang.model;

import java.sql.Date;

public class HoaDon extends Common<HoaDon> {

	private Date ngayHD;
	private double tongTien;
	
	public HoaDon() {
	}
	
	public HoaDon(Date ngayHD, double tongTien) {
		this.ngayHD = ngayHD;
		this.tongTien = tongTien;
	}
	
	public Date getNgayHD() {
		return ngayHD;
	}
	public void setNgayHD(Date ngayHD) {
		this.ngayHD = ngayHD;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
}
