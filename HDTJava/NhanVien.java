package DAC;
import java.io.Serializable;

import java.util.ArrayList;

public class NhanVien extends Nguoi implements Serializable{
	private String maNV;
	private float Luong;
	private String chucVu;
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public float getLuong() {
		return Luong;
	}
	public void setLuong(float luong) {
		Luong = luong;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public NhanVien(String hoTen, int tuoi, String maNV, float luong, String chucVu) {
		super(hoTen, tuoi);
		this.maNV = maNV;
		Luong = luong;
		this.chucVu = chucVu;
	}
	public NhanVien(String hoTen, int tuoi) {
		super(hoTen, tuoi);
	}
	
	
	
}
