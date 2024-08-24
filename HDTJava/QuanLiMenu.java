package DAC;
import java.util.*;
public class QuanLiMenu {
public ArrayList<Menu> dstd=new ArrayList<Menu>();
MenuDao obj=new MenuDao();
Scanner sc=new Scanner(System.in);
public void khoiTao() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Nhập số lượng món:");
	int sl = sc.nextInt();
	sc.nextLine();
	for(int i=0;i<sl;i++) {
		System.out.println("Nhap ma mon:");
		String maMon=sc.nextLine();
		maMon=check(maMon);
		System.out.println("Nhap ten mon:");
		String tenMon=sc.nextLine();
		tenMon=check(tenMon);
		System.out.println("Nhap gia:");
		float gia =sc.nextFloat();
		gia=check(gia);
		sc.nextLine();
		Menu mn =new Menu(maMon,tenMon,gia);
		dstd.add(mn);
	}
obj.ghiFile(dstd);
}

public void docFile()
{
	dstd=obj.docFile("f:\\dstd.bin");
}
public void timKiemTheoTen() {
    System.out.println("Nhập tên món ăn cần tìm kiếm:");
    String tenCanTim = sc.nextLine();
    tenCanTim = check1(tenCanTim);

    boolean found = false;

    System.out.println("+--------------+---------------+--------------+");
    System.out.println("| Ma mon       | Ten mon       |     Gia      |");
    System.out.println("+--------------+---------------+--------------+");


    for (Menu mn : dstd) {
        if (mn.getTenMon().equalsIgnoreCase(tenCanTim)) {
        	System.out.printf("| %12s | %-13s | %-13.3f|\n", 
        			mn.getMaMon().toUpperCase(),mn.getTenMon().toUpperCase(),mn.getGia());
            found = true;
        }
    }

    if (!found) {
        System.out.println("Không tìm thấy món ăn với tên: " + tenCanTim);
    }

    System.out.println("+--------------+---------------+--------------+");
}
public void hienthi()
{
	docFile();
System.out.println("+--------------+---------------+--------------+");
System.out.println("| Ma mon       | Ten mon       |     Gia      |");
System.out.println("+--------------+---------------+--------------+");

for (Menu mn : dstd) 
{
    System.out.printf("| %12s | %-13s | %-13.3f|\n", mn.getMaMon().toUpperCase(),mn.getTenMon().toUpperCase(),mn.getGia());
}
System.out.println("+--------------+---------------+--------------+");
}
public void hienThiDK(float gia1)
{	System.out.println("+--------------+---------------+--------------+");
System.out.println("| Ma mon       | Ten mon       |     Gia      |");
System.out.println("+--------------+---------------+--------------+");
	for (Menu mn : dstd) 
	{
	if(mn.getGia()>=gia1)
	 {
	    System.out.printf("| %12s | %-13s | %-13.3f|\n", mn.getMaMon().toUpperCase(),mn.getTenMon().toUpperCase(),mn.getGia());
	
	System.out.println("+--------------+---------------+--------------+");
	 }
	}
}

public void themMonAn() {
	for(int i=0;i<1;i++)
	{
		System.out.println("Nhập ãm món:");
		String maMon=sc.nextLine();
		maMon=check(maMon);
		if (kiemTraTrungMa(maMon)) {
            System.out.println("Mã món " + maMon + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
            i--; 
            continue; 
        }
		System.out.println("Nhập tên món:");
		String tenMon=sc.nextLine();
		tenMon=check(tenMon);
		System.out.println("Nhập giá:");
		float gia =sc.nextFloat();
		gia=check(gia);
		sc.nextLine();
		Menu mn =new Menu(maMon,tenMon,gia);
		dstd.add(mn);
	}
obj.ghiFile(dstd);
}  
public boolean kiemTraTrungMa(String maMon) {
    for (Menu mn : dstd) {
        if (mn.getMaMon().equalsIgnoreCase(maMon)) {
            return true; 
        }
    }
    return false; 
}
public void xoa(String ma) {
	for(int i=0; i<dstd.size();i++)
	{
		if(dstd.get(i).getMaMon().equals(ma)==true)
			dstd.remove(i);
	}
	obj.ghiFile(dstd);
}
public String check (String maMon) {

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
			System.out.print("Ban da nhap sai(Ma mon ban Null");}
		
	} return(maMon);
}
public String check1(String tenMon) {

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
			System.out.print("Ban da nhap sai(Ho ten ban Null");}
		
	} return(tenMon);
}
public float check(float gia) {
	while(true)
	{
		try {
			if((gia>0) && (gia<=100000000)) break;
			else {
				System.out.println("Gia khong hop le");
				System.out.print("nhap lai");
				gia=sc.nextInt();
			}
		}catch(Exception e) {
			System.out.print("Ban da nhap sai(Gia ban Null");}
		
	} return(gia);

}

}
