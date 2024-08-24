package DAC;

import java.io.Serializable;

public class HoaDon extends Menu implements Serializable {
	
		private String maHD;
		private String maKh;
		private int soLuong;
		private float thanhTien;
		
		public float getThanhTien() {
			return thanhTien;
		}
		public void setThanhTien(float thanhTien) {
			this.thanhTien = thanhTien;
		}
		public String getMaHD() {
			return maHD;
		}
		public void setMaHD(String maHD) {
			this.maHD = maHD;
		}
		public String getMaKh() {
			return maKh;
		}
		public void setMaKh(String maKh) {
			this.maKh = maKh;
		}
		public int getSoLuong() {
			return soLuong;
		}
		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}
		public HoaDon(String maMon, String tenMon, float gia, String maHD, String maKh, int soLuong) {
			super(maMon, tenMon, gia);
			this.maHD = maHD;
			this.maKh = maKh;
			this.soLuong = soLuong;
			
		}
		public HoaDon() {
			
		}
		
		
		
		
}
