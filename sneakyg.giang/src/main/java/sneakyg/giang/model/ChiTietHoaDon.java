package sneakyg.giang.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDon extends Common<ChiTietHoaDon> {

	private int soLuong;
	private double thanhTien;
	private Timestamp thoiGian;
	private Integer maSach;
	private Integer maKhachHang;
	private Integer maNhanVien;
	private Integer maHoaDon;
	private List<Sach> dsTenSach = new ArrayList<>();

	public Integer getMaSach() {
		return maSach;
	}

	public void setMaSach(Integer maSach) {
		this.maSach = maSach;
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

	public Integer getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(Integer maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public List<Sach> getDsTenSach() {
		return dsTenSach;
	}

	public void setDsTenSach(List<Sach> dsTenSach) {
		this.dsTenSach = dsTenSach;
	}

	public Timestamp getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

}
