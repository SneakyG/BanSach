package sneakyg.giang.model;

public class TaiKhoan extends Common<TaiKhoan> {

	private String tenTaiKhoan;
	private String matKhau;
	private int trangThai;
	private Integer maChucVu;
	ChucVu cv = new ChucVu();
	
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public ChucVu getCv() {
		return cv;
	}
	public void setCv(ChucVu cv) {
		this.cv = cv;
	}
	public Integer getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(Integer maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
}
