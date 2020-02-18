package sneakyg.giang.model;

import java.sql.Timestamp;

public class HoaDon extends Common<HoaDon> {

	private Timestamp thoiGianDat;
	private Timestamp thoiGianMua;
	private Integer maKhachHang;
	private Integer maNhanVien;
	private double tongTien;
	private int trangThai;

	public HoaDon() {
	}
	
	public HoaDon(Timestamp thoiGianDat, double tongTien, int trangThai) {
		this.thoiGianDat = thoiGianDat;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}

	public Timestamp getThoiGianDat() {
		return thoiGianDat;
	}

	public void setThoiGianDat(Timestamp thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
	}

	public Timestamp getThoiGianMua() {
		return thoiGianMua;
	}

	public void setThoiGianMua(Timestamp thoiGianMua) {
		this.thoiGianMua = thoiGianMua;
	}

	public Integer getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(Integer maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Integer getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Integer maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	public HoaDon(double tongTien) {
		this.tongTien = tongTien;
	}
	
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
}
