package model;

import java.time.LocalDateTime;

public class LichChieu325 {
	private int id;
	private int phim;
	private String phong;
	private int nhanvienquanli;
	private LocalDateTime thoigianbatdau;
	private LocalDateTime thoigianketthuc;

	public LichChieu325() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public LichChieu325(int phim, String phong, int nhanvienquanli, LocalDateTime thoigianbatdau,
//			LocalDateTime thoigianketthuc) {
//		super();
//		this.phim = phim;
//		this.phong = phong;
//		this.nhanvienquanli = nhanvienquanli;
//		this.thoigianbatdau = thoigianbatdau;
//		this.thoigianketthuc = thoigianketthuc;
//	}

	@Override
	public String toString() {
		return "LichChieu325 [id=" + id + ", phim=" + phim + ", phong=" + phong + ", nhanvienquanli=" + nhanvienquanli
				+ ", thoigianbatdau=" + thoigianbatdau + ", thoigianketthuc=" + thoigianketthuc + "]";
	}

	public LichChieu325(int id, int phim, String phong, int nhanvienquanli, LocalDateTime thoigianbatdau,
			LocalDateTime thoigianketthuc) {
		super();
		this.id = id;
		this.phim = phim;
		this.phong = phong;
		this.nhanvienquanli = nhanvienquanli;
		this.thoigianbatdau = thoigianbatdau;
		this.thoigianketthuc = thoigianketthuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhim() {
		return phim;
	}

	public void setPhim(int phim) {
		this.phim = phim;
	}

	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}

	public int getNhanvienquanli() {
		return nhanvienquanli;
	}

	public void setNhanvienquanli(int nhanvienquanli) {
		this.nhanvienquanli = nhanvienquanli;
	}

	public LocalDateTime getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(LocalDateTime thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public LocalDateTime getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(LocalDateTime thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	// Constructors, getters, setters
}
