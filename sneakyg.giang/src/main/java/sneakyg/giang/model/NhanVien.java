package sneakyg.giang.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVien extends KhachHang {
	
	private List<NhanVien> dsNV = new ArrayList<NhanVien>();
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
	public List<NhanVien> getDsNV() {
		return dsNV;
	}
	public void setDsNV(List<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
}
