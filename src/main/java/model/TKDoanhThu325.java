package model;

import java.time.LocalDateTime;

public class TKDoanhThu325 extends HoaDon325 {
	private int tongdoanhthu;

	// Constructors, getters, setters, and other methods can be added here

	public TKDoanhThu325(int id, int khachhang, int tongtien, int nhanvienbanhang, LocalDateTime thoigianxuat,
			int tongdoanhthu) {
		super(id, khachhang, tongtien, nhanvienbanhang, thoigianxuat);
		this.tongdoanhthu = tongdoanhthu;
	}

	public int getTongdoanhthu() {
		return tongdoanhthu;
	}

	public void setTongdoanhthu(int tongdoanhthu) {
		this.tongdoanhthu = tongdoanhthu;
	}

	// You can add other methods or functionality related to TKDoanhThu325 here
}