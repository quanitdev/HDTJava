package DAC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class QuanLiKhachHang {
KhachHangDao obj=new KhachHangDao();
public ArrayList<KhachHang> dskh=new ArrayList<KhachHang>();

Scanner sc=new Scanner(System.in);
public void nhap()
{
	System.out.println("Nhập số lượng khách hàng:");
	Scanner sc = new Scanner(System.in);
	int sl = sc.nextInt();
	sc.nextLine();
	for(int i=0;i<sl;i++)
	{
		System.out.println("Nhập mã khách hàng:");
		String maKH=sc.nextLine();
		maKH=check(maKH);
		if (kiemTraTrungMa(maKH)) {
            System.out.println("Mã nhân viên " + maKH + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
            i--; 
            continue; 
        }
		System.out.println("Nhap ten khach hang");
		String hoTen=sc.nextLine();
		hoTen=check(hoTen);
		System.out.println("Nhap tuoi:");
		int tuoi=sc.nextInt();
		sc.nextLine();
		tuoi=check(tuoi);
		System.out.println("Nhap  ma mon");
		String maMon=sc.nextLine();
		maMon=check(maMon);
		System.out.println("Nhap so luong:");
		int soLuong=sc.nextInt();
		sc.nextLine();
		soLuong=check2(soLuong);
		KhachHang kh=new KhachHang(hoTen,tuoi,soLuong,maMon,maKH);
		dskh.add(kh);
	}
	obj.ghiFile(dskh);
}
public void docFile() {
	dskh= obj.docFile("f:\\dskh.txt");
}

public boolean kiemTraTrungMa(String maKH) {
    for (KhachHang kh : dskh) {
        if (kh.getMaKH().equalsIgnoreCase(maKH)) {
            return true; // 
        }
    }
    return false; 
}

public void timKiemTheoTen() {
    System.out.println("Nhập tên khách hàng cần tìm kiếm:");
    String tenCanTim = sc.nextLine();
    tenCanTim = check1(tenCanTim);

    boolean found = false;

    System.out.println("+--------+-----------------+------+---------+----------+");
    System.out.println("| Mã KH  |  Tên Khách Hàng | Tuổi | Mã món  | Số lượng |");
    System.out.println("+--------+-----------------+------+---------+----------+");

    for (KhachHang kh : dskh) {
        if (kh.getHoTen().equalsIgnoreCase(tenCanTim)) {
        	System.out.printf("| %-6s | %-15s | %-4d |%-8s | %-8d |\n",
        	kh.getMaKH().toUpperCase(),kh.getHoTen().toUpperCase(),kh.getTuoi(),kh.getMaMon().toUpperCase(),kh.getSoLuong());
            found = true;
        }
    }

    if (!found) {
        System.out.println("Không tìm thấy khách hàng với tên: " + tenCanTim);
    }

    System.out.println("+--------+-----------------+------+---------+----------+");
}
public void sapXepTheoTen() {
    Collections.sort(dskh, new Comparator<KhachHang>() {
        @Override
        public int compare(KhachHang kh1, KhachHang kh2) {
            // Using compareToIgnoreCase to compare employees by name (case-insensitive)
            return kh1.getHoTen().compareToIgnoreCase(kh2.getHoTen());
        }
    });

    System.out.println("+--------+-----------------+------+---------+----------+");
    System.out.println("| Mã KH  |  Tên Khách Hàng | Tuổi | Mã món  | Số lượng |");
    System.out.println("+--------+-----------------+------+---------+----------+");


    for (KhachHang kh : dskh) {
    	System.out.printf("| %-6s | %-15s | %-4d |%-8s | %-8d |\n",
    			kh.getMaKH().toUpperCase(),kh.getHoTen().toUpperCase(),kh.getTuoi(),kh.getMaMon().toUpperCase(),kh.getSoLuong());
    }

    System.out.println("+--------+-----------------+------+---------+----------+");
}

public void capNhatThongTinKhachHang(String maKH) {
    boolean found = false;

    for (KhachHang kh : dskh) {
        if (kh.getMaKH().equalsIgnoreCase(maKH)) {
            found = true;

            System.out.println("Nhập thông tin cập nhật cho khách hàng " + maKH + ":");

            System.out.print("Họ tên mới: ");
            String hoTenMoi = sc.nextLine();
            hoTenMoi = check1(hoTenMoi);

            System.out.print("Tuổi mới: ");
            int tuoiMoi = sc.nextInt();
            tuoiMoi = check(tuoiMoi);
            sc.nextLine();

            System.out.print("Mã món mới: ");
            String maMonMoi = sc.nextLine();
            maMonMoi = check2(maMonMoi);

            System.out.print("Số lượng mới: ");
            int soLuongMoi = sc.nextInt();
            soLuongMoi = check(soLuongMoi);
            sc.nextLine();

            // Update employee information
            kh.setHoTen(hoTenMoi);
            kh.setTuoi(tuoiMoi);
            kh.setMaMon(maMonMoi);
            kh.setSoLuong(soLuongMoi);

            System.out.println("Thông tin khách hàng " + maKH + " đã được cập nhật.");
            break; // Exit the loop once the employee is found and updated
        }
    }

    if (!found) {
        System.out.println("Không tìm thấy khách hàng với mã: " + maKH);
    }

    obj.ghiFile(dskh);
}

public void hienthi()
{
	docFile();
	System.out.println("+--------+-----------------+------+---------+----------+");
    System.out.println("| Mã KH  |  Tên Khách Hàng | Tuổi | Mã món  | Số lượng |");
    System.out.println("+--------+-----------------+------+---------+----------+");

    for (KhachHang kh : dskh) {
        System.out.printf("| %-6s | %-15s | %-4d |%-8s | %-8d |\n", kh.getMaKH().toUpperCase(),kh.getHoTen().toUpperCase(),kh.getTuoi(),kh.getMaMon().toUpperCase(),kh.getSoLuong());
    }
    System.out.println("+--------+-----------------+------+---------+----------+");
}
public void hienThiDK(int sl1)
{System.out.println("+--------+-----------------+------+---------+----------+");
System.out.println("| Mã KH  |  Tên Khách Hàng | Tuổi | Mã món  | Số lượng |");
System.out.println("+--------+-----------------+------+---------+----------+");
	for(KhachHang kh:dskh)
	{ if(kh.getSoLuong()==sl1)
	{
		System.out.printf("| %-6s | %-15s | %-4d |%-8s | %-8d |\n", kh.getMaKH().toUpperCase(),kh.getHoTen().toUpperCase(),kh.getTuoi(),kh.getMaMon().toUpperCase(),kh.getSoLuong());
	    
	    System.out.println("+--------+-----------------+------+---------+----------+");
	}
	}
}
public void themKhachHang(){
	
	for(int i=0;i<1;i++)
	{
		System.out.println("Nhap ma KH");
		String maKH=sc.nextLine();
		maKH=check(maKH);
		if (kiemTraTrungMa(maKH)) {
            System.out.println("Mã nhân viên " + maKH + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
            i--; 
            continue; 
        }
		System.out.println("Nhập họ tên khách hàng:");
		String hoTen=sc.nextLine();
		hoTen=check(hoTen);
		System.out.println("Nhập tuổi:");
		int tuoi=sc.nextInt();
		sc.nextLine();
		tuoi=check(tuoi);
		System.out.println("NHập mã món");
		String maMon=sc.nextLine();
		maMon=check(maMon);
		System.out.println("Nhập số lượng:");
		int soLuong=sc.nextInt();
		sc.nextLine();
		soLuong=check2(soLuong);
		KhachHang kh=new KhachHang(hoTen,tuoi,soLuong,maMon,maKH);
		dskh.add(kh);
	}
	obj.ghiFile(dskh);
}

public void xoa(String kh) {
for(int i=0; i<dskh.size();i++)
{
	if(dskh.get(i).getMaKH().equals(kh)==true)
		dskh.remove(i);
}
obj.ghiFile(dskh);
}
public void hienThiLonNhat() {
	float max=0;
	    for (KhachHang kh: dskh) {
	        if (max <kh.getSoLuong())max=kh.getSoLuong() ;
	    }
	    System.out.println("+--------+-----------------+------+---------+----------+");
	    System.out.println("| Mã KH  |  Tên Khách Hàng | Tuổi | Mã món  | Số lượng |");
	    System.out.println("+--------+-----------------+------+---------+----------+");
	    for (KhachHang kh: dskh) {
	    	 if(kh.getSoLuong()==max)
	    	 {
	    		 System.out.printf("| %-6s | %-15s | %-4d |%-8s | %-8d |\n",  kh.getMaKH().toUpperCase(),kh.getHoTen().toUpperCase(),kh.getTuoi(),kh.getMaMon().toUpperCase(),kh.getSoLuong());
		    
		    System.out.println("+--------+-----------------+------+---------+----------+");
		}
	        }
}
public String check(String maKH) {

	while (true)
	{
		try {
			if(maKH.length()!=0) break;
			else {
				System.out.println("Khong duoc null");
				System.out.print("nhap lai");
				maKH=sc.nextLine();
			}
			
		}catch(Exception e) {
			System.out.print("Ban da nhap sai(ma Kh ban Null");}
		
	} return(maKH);
}


public String check1(String hoTen) {

	while (true)
	{
		try {
			if(hoTen.length()!=0) break;
			else {
				System.out.println("Khong duoc null");
				System.out.print("nhap lai");
				hoTen=sc.nextLine();
			}
			
		}catch(Exception e) {
			System.out.print("Ban da nhap sai(Ho ten ban Null");}
		
	} return(hoTen);
}
public String check2(String maMon) {

	while (true)
	{
		try {
			if(maMon.length()!=0) break;
			else {
				System.out.println("Khong duoc null");
				System.out.print("nhap lai");
				maMon=sc.nextLine();
			}
			
		}catch(Exception e) {
			System.out.print("Ban da nhap sai(Ma món ban Null");}
		
	} return(maMon);
}

public int check(int tuoi) {
	while(true)
	{
		try {
			if((tuoi>18) && (tuoi<=50)) break;
			else {
				System.out.println("tuoi khong hop le");
				System.out.print("nhap lai");
				tuoi=sc.nextInt();
			}
		}catch(Exception e) {
			System.out.print("Ban da nhap sai(Tuoi ban Null");}
		
	} return(tuoi);

}
public int check2 (int soLuong) {
	while(true)
	{
		try {
			if(soLuong>0) break;
			else {
				System.out.println(" so luong khong hop le");
				System.out.print("nhap lai");
				soLuong=sc.nextInt();
			}
		}catch(Exception e) {
			System.out.print("Ban da nhap sai( So luong ban Null");}
		
	} return (soLuong);

}
public String laymonBangMa(String maKH) {
	System.out.print(dskh.size());
	for (int i = 0; i < dskh.size(); i++) {
		System.out.print(dskh.get(i).getMaKH().equals(maKH));
		if (dskh.get(i).getMaKH().equals(maKH)) {
			return dskh.get(i).getMaMon();
		}
		return null;
	}
	return null;
}
}
