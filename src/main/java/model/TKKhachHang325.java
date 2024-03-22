package model;

public class TKKhachHang325 extends KhachHang325 {
	private int solanmua;

	// Constructor của lớp TKKhachHang325
	public TKKhachHang325(int id, int thanhvien, String thethanhvien, int solanmua) {
		super(id, thanhvien, thethanhvien);
		this.solanmua = solanmua;
	}

	public int getSolanmua() {
		return solanmua;
	}

	public void setSolanmua(int solanmua) {
		this.solanmua = solanmua;
	}

}
