package model;

import java.time.LocalDate;

public class ThanhVien325 {
	private int id;
	private String hoten;
	private String sodienthoai;
	private LocalDate ngaysinh;
	private String diachi;

	public ThanhVien325() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ThanhVien325 [id=" + id + ", hoten=" + hoten + ", sodienthoai=" + sodienthoai + ", ngaysinh=" + ngaysinh
				+ ", diachi=" + diachi + "]";
	}

	public ThanhVien325(int id, String hoten, String sodienthoai, LocalDate ngaysinh, String diachi) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.sodienthoai = sodienthoai;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public LocalDate getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	// Constructors, getters, setters
}