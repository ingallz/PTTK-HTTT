package model;

public class Phim325 {
	private int id;
	private String ten;
	private String mota;
	private String theloai;
	private String daodien;
	private String thoiluong;
	private boolean dangchieu;

	public Phim325() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Phim325(int id, String ten, String mota, String theloai, String daodien, String thoiluong,
			boolean dangchieu) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
		this.theloai = theloai;
		this.daodien = daodien;
		this.thoiluong = thoiluong;
		this.dangchieu = dangchieu;
	}

	@Override
	public String toString() {
		return "Phim325 [ten=" + ten + ", mota=" + mota + ", theloai=" + theloai + ", daodien=" + daodien
				+ ", thoiluong=" + thoiluong + ", dangchieu=" + dangchieu + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	public String getDaodien() {
		return daodien;
	}

	public void setDaodien(String daodien) {
		this.daodien = daodien;
	}

	public String getThoiluong() {
		return thoiluong;
	}

	public void setThoiluong(String thoiluong) {
		this.thoiluong = thoiluong;
	}

	public boolean isDangchieu() {
		return dangchieu;
	}

	public void setDangchieu(boolean dangchieu) {
		this.dangchieu = dangchieu;
	}

	// Constructors, getters, setters
}