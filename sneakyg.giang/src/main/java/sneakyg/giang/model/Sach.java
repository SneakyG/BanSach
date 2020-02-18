package sneakyg.giang.model;

public class Sach extends Common<Sach> {

	private String tenSach;
	private String moTaNgan;
	private int soLuong;
	private String hinhAnh;
	private double donGia;
	private Integer maNXB;
	private Integer maTacGia;
	private Integer maDanhMuc;
	private TacGia tg = new TacGia();
	private NhaXuatBan nxb = new NhaXuatBan();
	private DanhMucSach dm = new DanhMucSach();
	
	public TacGia getTg() {
		return tg;
	}
	public void setTg(TacGia tg) {
		this.tg = tg;
	}
	public NhaXuatBan getNxb() {
		return nxb;
	}
	public void setNxb(NhaXuatBan nxb) {
		this.nxb = nxb;
	}
	public DanhMucSach getDm() {
		return dm;
	}
	public void setDm(DanhMucSach dm) {
		this.dm = dm;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public Integer getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(Integer maNXB) {
		this.maNXB = maNXB;
	}
	public Integer getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(Integer maTacGia) {
		this.maTacGia = maTacGia;
	}
	public Integer getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(Integer maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getMoTaNgan() {
		return moTaNgan;
	}
	public void setMoTaNgan(String moTaNgan) {
		this.moTaNgan = moTaNgan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
