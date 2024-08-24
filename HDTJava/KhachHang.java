package DAC;
import java.io.Serializable;
import java.util.ArrayList;
public class KhachHang extends Nguoi implements Serializable{
	private int soLuong;;
	//private String tenMon;
	private String maMon;
	private String maBan;
	private String maKH;
	
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	//public String getTenMon() {
	//	return tenMon;
	//}
//	public void setTenMon(String tenMon) {
	//	this.tenMon = tenMon;
//	}
	public String getMaBan() {
		return maBan;
	}
	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}
	public KhachHang(String hoTen, int tuoi, int soLuong, String maMon, String maKH) {
		super(hoTen, tuoi);
		this.soLuong = soLuong;
		this.maMon = maMon;
		//this.maBan = maBan;
		this.maKH = maKH;
	}
	public KhachHang(String hoTen, int tuoi) {
		super(hoTen, tuoi);
	}
	
	
	
	}
	