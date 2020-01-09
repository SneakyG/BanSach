package sneakyg.giang.model;

public class DanhMucSach extends Common<DanhMucSach> {

	private String tenCode;
	private String tenDanhMuc;
	
	public String getTenCode() {
		return tenCode;
	}
	public void setTenCode(String tenCode) {
		this.tenCode = tenCode;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
}
