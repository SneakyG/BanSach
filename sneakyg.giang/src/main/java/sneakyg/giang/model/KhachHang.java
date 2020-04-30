package sneakyg.giang.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachHang extends Common<KhachHang> {

	protected String ten;
	protected String email;
	protected String sdt;
	protected String cmnd;
	protected Date ngaySinh;
	protected String diaChi;
	protected Integer maTaiKhoan;
	protected TaiKhoan tk = new TaiKhoan();
	private List<KhachHang> dsKH = new ArrayList<KhachHang>();
	
	public KhachHang() {}
	
	public KhachHang(Integer maTaiKhoan, String ten) {
		this.ten = ten;
		email = "";
		cmnd = "";
		diaChi = "";
		this.maTaiKhoan = maTaiKhoan;
	}
	public TaiKhoan getTk() {
		return tk;
	}
	public void setTk(TaiKhoan tk) {
		this.tk = tk;
	}
	public Integer getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(Integer maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public List<KhachHang> getDsKH() {
		return dsKH;
	}
	public void setDsKH(List<KhachHang> dsKH) {
		this.dsKH = dsKH;
	}
}
