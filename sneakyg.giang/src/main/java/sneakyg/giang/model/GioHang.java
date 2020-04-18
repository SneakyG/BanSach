package sneakyg.giang.model;

public class GioHang extends Common<GioHang> {

	private int maTaiKhoan;
	private int maSach;
	private int soLuong;
	private double tongTien;
	private double tongTienTatCa;
	private String tenSach;
	private String tenTG;
	private String hinhAnh;
	
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public double getTongTienTatCa() {
		return tongTienTatCa;
	}
	public void setTongTienTatCa(double tongTienTatCa) {
		this.tongTienTatCa = tongTienTatCa;
	}
	
}
