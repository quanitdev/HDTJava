package DAC;
import java.io.Serializable;
public class Menu implements Serializable {
private String maMon;
private String tenMon;
private float gia;
public String getMaMon() {
	return maMon;
}
public void setMaMon(String maMon) {
	this.maMon = maMon;
}
public String getTenMon() {
	return tenMon;
}
public void setTenMon(String tenMon) {
	this.tenMon = tenMon;
}
public float getGia() {
	return gia;
}
public void setGia(float gia) {
	this.gia = gia;
}
public Menu(String maMon, String tenMon, float gia) {
	super();
	this.maMon = maMon;
	this.tenMon = tenMon;
	this.gia = gia;
}
public Menu() {
	super();
}


}