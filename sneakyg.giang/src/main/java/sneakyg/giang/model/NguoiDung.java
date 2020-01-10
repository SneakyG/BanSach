package sneakyg.giang.model;

import java.util.Date;

public class NguoiDung {

	protected Integer id;
	protected String ten;
	protected String email;
	protected String sdt;
	protected String cmnd;
	protected Date ngaySinh;
	protected String diaChi;
	protected int maTaiKhoan;
	protected TaiKhoan tk = new TaiKhoan();
}
