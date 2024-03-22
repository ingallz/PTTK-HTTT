package model;

public class TaiKhoan325 {
	private String email;
	private String username;
	private String password;
	private int thanhvien;

	public TaiKhoan325() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan325(String email, String username, String password, int thanhvien) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.thanhvien = thanhvien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getThanhvien() {
		return thanhvien;
	}

	public void setThanhvien(int thanhvien) {
		this.thanhvien = thanhvien;
	}

	// Constructors, getters, setters
}
