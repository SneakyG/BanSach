package sneakyg.giang.model;

import java.util.Date;

public class HoaDon extends Common<HoaDon> {

	private Date ngayHD;
	private double tongTien;
	
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
