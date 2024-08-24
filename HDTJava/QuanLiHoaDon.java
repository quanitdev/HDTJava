package DAC;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiHoaDon {
	public ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
	Scanner sc=new Scanner(System.in);
	HoaDonDao obj=new HoaDonDao();
	public void nhap()
	{
		System.out.println("Nhập số lượng hóa đơn:");
		Scanner sc = new Scanner(System.in);
		int sl = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<sl;i++)
		{
			System.out.println("Nhap ma HD");
			String maHd=sc.nextLine();
			maHd=check(maHd);
			if (kiemTraTrungMa(maHd)) {
	            System.out.println("Mã hóa đơn " + maHd + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
	            i--; 
	            continue; 
	        }
			System.out.println("Nhập mã khách hàng:");
			String maKh=sc.nextLine();
			maKh=check(maKh);
			System.out.println("Nhập mã món:");
			String maMon=sc.nextLine();
			System.out.println("Nhập tên món:");
			String tenMon=sc.nextLine();
			tenMon=check(tenMon);
			System.out.println("Nhập số lượng:");
			int soLuong=sc.nextInt();
			soLuong=check(soLuong);
			sc.nextLine();
			System.out.println("Nhập giá: ");
			Float gia=sc.nextFloat();
			gia=check(gia);
			sc.nextLine();
			HoaDon hd=new HoaDon(maMon,tenMon,gia,maHd,maKh,soLuong );
			dshd.add(hd);
		}
		tinhThanhTien();
		obj.ghiFile(dshd);
		
	}
	public void docFile() {
		dshd= obj.docFile("f:\\dshd.txt");
	}
	public void tinhThanhTien() {
		for(HoaDon hd:dshd) {
			float thanhTien = hd.getGia()*hd.getSoLuong();
			hd.setThanhTien(thanhTien);
		}
	}
	public void timKiemTheoMa() {
	    System.out.println("Nhập mã món cần tìm kiếm:");
	    String maCanTim = sc.nextLine();
	    maCanTim = check1(maCanTim);

	    boolean found = false;

	    System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
	    System.out.println("| Mã hóa đơn |  Mã KH   | Mã món |  Tên món   | Số lượng  |     Giá   | Thành tiền    |");
        System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");

	    for (HoaDon hd : dshd) {
	        if (hd.getMaHD().equalsIgnoreCase(maCanTim)) {
	        	System.out.printf("|%-12s|%-10s|%-8s|%10s  |    %-7d|%-11.3f|%-15.3f|\n",
	        			hd.getMaHD().toUpperCase(),hd.getMaKh().toUpperCase(),hd.getMaMon().toUpperCase(),hd.getTenMon().toUpperCase(),hd.getSoLuong(),hd.getGia(),hd.getThanhTien());
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("Không tìm thấy hóa đơn với mã: " + maCanTim);
	    }

	    System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
	}
	
	public void hienthi()
	{
		docFile();
		 	System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
		    System.out.println("| Mã hóa đơn |  Mã KH   | Mã món |  Tên món   | Số lượng  |     Giá   | Thành tiền    |");
	        System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");


        for (HoaDon hd : dshd) {
        System.out.printf("|%-12s|%-10s|%-8s|%10s  |    %-7d|%-11.3f|%-15.3f|\n", hd.getMaHD().toUpperCase(),hd.getMaKh().toUpperCase(),hd.getMaMon().toUpperCase(),hd.getTenMon().toUpperCase(),hd.getSoLuong(),hd.getGia(),hd.getThanhTien());
        }

        	System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
	}
	
	public void hienThiDK(float thanhtien1)
	{
		System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
	    System.out.println("| Mã hóa đơn |  Mã KH   | Mã món |  Tên món   | Số lượng  |     Giá   | Thành tiền    |");
        System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");

		for(HoaDon hd:dshd)
		{ if(hd.getThanhTien()>=thanhtien1)
		{
			System.out.printf("|%-12s|%-10s|%-8s|%10s  |    %-7d|%-11.3f|%-15.3f|\n", hd.getMaHD().toUpperCase(),hd.getMaKh().toUpperCase(),hd.getMaMon().toUpperCase(),hd.getTenMon().toUpperCase(),hd.getSoLuong(),hd.getGia(),hd.getThanhTien());
		
			System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
		}
		}
		}
	
	public void xoa(String maHd) {
	for(int i=0; i< dshd.size();i++)
	{
		if(dshd.get(i).getMaHD().equals(maHd)==true)
			dshd.remove(i);	
	}
	obj.ghiFile(dshd);
	}
	public void hienThiLonNhat() {
		float max=0;
		    for (HoaDon hd: dshd) {
		        if (max <hd.getThanhTien())max=hd.getThanhTien() ;
		    }
		     for (HoaDon hd:dshd) {
		    	 if(hd.getThanhTien()==max) {
		    		 System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
		    		    System.out.println("| Mã hóa đơn |  Mã KH   | Mã món |  Tên món   | Số lượng  |     Giá   | Thành tiền    |");
		    	        System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
		    	        System.out.printf("|%-12s|%-10s|%-8s|%10s  |    %-7d|%-11.3f|%-15.3f|\n", hd.getMaHD().toUpperCase(),hd.getMaKh().toUpperCase(),hd.getMaMon().toUpperCase(),hd.getTenMon().toUpperCase(),hd.getSoLuong(),hd.getGia(),hd.getThanhTien());
		    			
		    			System.out.println("+------------+----------+--------+------------+-----------+-----------+---------------+");
		    	 }
		        }
		     obj.ghiFile(dshd);
	}
	public String check(String maHd) {

		while (true)
		{
			try {
				if(maHd.length()!=0) break;
				else {
					System.out.println("Khong duoc null");
					System.out.print("nhap lai");
					maHd=sc.nextLine();
				}
				
			}catch(Exception e) {
				System.out.print("Ban da nhap sai(Ma hoa don ban Null");}
			
		} return(maHd);
	}
	public boolean kiemTraTrungMa(String maHD) {
	    for (HoaDon hd : dshd) {
	        if (hd.getMaHD().equalsIgnoreCase(maHD)) {
	            return true; 
	        }
	    }
	    return false; 
	}
	public String check1(String maKh) {

		while (true)
		{
			try {
				if(maKh.length()!=0) break;
				else {
					System.out.println("Khong duoc null");
					System.out.print("nhap lai");
					maKh=sc.nextLine();
				}
				
			}catch(Exception e) {
				System.out.print("Ban da nhap sai(Ma ban ban Null");}
			
		} return(maKh);
	}
	public String check2(String tenMon) {

		while (true)
		{
			try {
				if(tenMon.length()!=0) break;
				else {
					System.out.println("Khong duoc null");
					System.out.print("nhap lai");
					tenMon=sc.nextLine();
				}
				
			}catch(Exception e) {
				System.out.print("Ban da nhap sai(Ten mon ban Null");}
			
		} return(tenMon);
	}

	public int check(int soLuong) {
		while(true)
		{
			try {
				if(soLuong>0)  break;
				else {
					System.out.println("so luong khong hop le");
					System.out.print("nhap lai");
					soLuong=sc.nextInt();
				}
			}catch(Exception e) {
				System.out.print("Ban da nhap sai(So luong ban Null");}
			
		} return(soLuong);

	}
	public Float check (Float gia) {
		while(true)
		{
			try {
				if(gia>=0) break;
				else {
					System.out.println("gia khong hop le");
					System.out.print("nhap lai");
					gia=sc.nextFloat();
				}
			}catch(Exception e) {
				System.out.print("Ban da nhap sai(Luong ban Null");}
			
		} return (gia);

	}
	}
