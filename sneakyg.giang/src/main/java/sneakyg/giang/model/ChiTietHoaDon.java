package sneakyg.giang.model;

public class ChiTietHoaDon extends Common<ChiTietHoaDon> {

	private int soLuong;
	private double thanhTien;
	private Integer maSach;
	private Integer maHoaDon;
	private int trangThai;
	private String tenSach;
//	private List<Sach> dsTenSach = new ArrayList<>();

	public Integer getMaSach() {
		return maSach;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public void setMaSach(Integer maSach) {
		this.maSach = maSach;
	}

	public Integer getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(Integer maHoaDon) {
		this.maHoaDon = maHoaDon;
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

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

}
