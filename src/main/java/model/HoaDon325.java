package model;

import java.time.LocalDateTime;

public class HoaDon325 {
	private int id;
	private int khachhang;
	private int tongtien;
	private int nhanvienbanhang;
	private LocalDateTime thoigianxuat;

	public HoaDon325() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon325(int id, int khachhang, int tongtien, int nhanvienbanhang, LocalDateTime thoigianxuat) {
		super();
		this.id = id;
		this.khachhang = khachhang;
		this.tongtien = tongtien;
		this.nhanvienbanhang = nhanvienbanhang;
		this.thoigianxuat = thoigianxuat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(int khachhang) {
		this.khachhang = khachhang;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public int getNhanvienbanhang() {
		return nhanvienbanhang;
	}

	public void setNhanvienbanhang(int nhanvienbanhang) {
		this.nhanvienbanhang = nhanvienbanhang;
	}

	public LocalDateTime getThoigianxuat() {
		return thoigianxuat;
	}

	public void setThoigianxuat(LocalDateTime thoigianxuat) {
		this.thoigianxuat = thoigianxuat;
	}

	// Constructors, getters, setters
}
