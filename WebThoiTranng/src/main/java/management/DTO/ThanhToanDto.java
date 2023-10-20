package management.DTO;

import management.entity.Mathang;

public class ThanhToanDto {

	private Mathang mathang;
	private int soluong;
	public ThanhToanDto(int soluong, String size, int dongia, int thanhtien) {
		super();
		this.soluong = soluong;
		this.size = size;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	private String size;
	private int dongia;
	private int thanhtien;
	public Mathang getMathang() {
		return mathang;
	}
	public void setMathang(Mathang mathang) {
		this.mathang = mathang;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	public ThanhToanDto(Mathang mathang, int soluong, String size, int dongia, int thanhtien) {
		super();
		this.mathang = mathang;
		this.soluong = soluong;
		this.size = size;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	public ThanhToanDto() {
		super();
	}
	
	
	
	
}
