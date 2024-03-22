package model;

public class TKPhim325 extends Phim325 {
	private int solanmua;

	public TKPhim325(int id, String ten, String mota, String theloai, String daodien, String thoiluong,
			boolean dangchieu, int solanmua) {
		super(id, ten, mota, theloai, daodien, thoiluong, dangchieu);

		this.solanmua = solanmua;
	}

	public int getSolanmua() {
		return solanmua;
	}

	public void setSolanmua(int solanmua) {
		this.solanmua = solanmua;
	}

}
