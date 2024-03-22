package model;

public class KhachHang325 {
	private int id;
	private int thanhvien;
	private String thethanhvien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThanhvien() {
		return thanhvien;
	}

	public void setThanhvien(int thanhvien) {
		this.thanhvien = thanhvien;
	}

	public String getThethanhvien() {
		return thethanhvien;
	}

	public void setThethanhvien(String thethanhvien) {
		this.thethanhvien = thethanhvien;
	}

	public KhachHang325(int id, int thanhvien, String thethanhvien) {
		super();
		this.id = id;
		this.thanhvien = thanhvien;
		this.thethanhvien = thethanhvien;
	}

	public KhachHang325() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors, getters, setters
}