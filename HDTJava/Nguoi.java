package DAC;

import java.io.Serializable;

public class Nguoi implements Serializable{
private String hoTen;
private int tuoi;

public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public int getTuoi() {
	return tuoi;
}
public void setTuoi(int tuoi) {
	this.tuoi = tuoi;
}
public Nguoi(String hoTen, int tuoi) {
	super();
	this.hoTen = hoTen;
	this.tuoi = tuoi;
}
public Nguoi() {
	super();
}
}
