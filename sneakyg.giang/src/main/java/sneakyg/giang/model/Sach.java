package sneakyg.giang.model;

import java.util.ArrayList;
import java.util.List;

public class Sach extends Common<Sach> {

	private String tenSach;
	private String moTaNgan;
	private int soLuong;
	private String hinhAnh;
	private List<String> fileHinhAnh = new ArrayList<String>();
	private double donGia;
	private Integer maNXB;
	private Integer maTacGia;
	private Integer maDanhMuc;
	private TacGia tg = new TacGia();
	private NhaXuatBan nxb = new NhaXuatBan();
	private DanhMucSach dm = new DanhMucSach();
	private List<TacGia> dsTenTacGia = new ArrayList<TacGia>();
	private List<NhaXuatBan> dsTenNXB  = new ArrayList<NhaXuatBan>();
	private List<DanhMucSach> dsTenDanhMuc = new ArrayList<DanhMucSach>();
	
	public List<TacGia> getDsTenTacGia() {
		return dsTenTacGia;
	}
	public void setDsTenTacGia(List<TacGia> dsTenTacGia) {
		this.dsTenTacGia = dsTenTacGia;
	}
	public List<NhaXuatBan> getDsTenNXB() {
		return dsTenNXB;
	}
	public void setDsTenNXB(List<NhaXuatBan> dsTenNXB) {
		this.dsTenNXB = dsTenNXB;
	}
	public List<DanhMucSach> getDsTenDanhMuc() {
		return dsTenDanhMuc;
	}
	public void setDsTenDanhMuc(List<DanhMucSach> dsTenDanhMuc) {
		this.dsTenDanhMuc = dsTenDanhMuc;
	}
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
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public List<String> getFileHinhAnh() {
		return fileHinhAnh;
	}
	public void setFileHinhAnh(List<String> fileHinhAnh) {
		this.fileHinhAnh = fileHinhAnh;
	}
}
