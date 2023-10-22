package management.bean;

import java.util.Date;

public class Donhang {
	private int mamh;
	private String tenSP;
	private int soluong;
	private Date ngaydat;
	private int tonggia;
	
	public Donhang() {
		
	}
	
	public Donhang(int mamh, String tenSP, int soluong, Date ngaydat, int tonggia) {
		super();
		this.mamh = mamh;
		this.tenSP = tenSP;
		this.soluong = soluong;
		this.ngaydat = ngaydat;
		this.tonggia = tonggia;
	}
	public int getMamh() {
		return mamh;
	}

	public void setMamh(int mamh) {
		this.mamh = mamh;
	}

	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Date getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}

	public int getTonggia() {
		return tonggia;
	}

	public void setTonggia(int tonggia) {
		this.tonggia = tonggia;
	}
}
