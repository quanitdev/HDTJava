package DAC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
public class QuanLiNhanVien  {
public ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
Scanner sc=new Scanner(System.in);

NhanVienDao obj=new NhanVienDao();
public void nhap()
{
	System.out.println("Nhập số lượng nhân viên:");
	Scanner sc = new Scanner(System.in);
	int sl = sc.nextInt();
	sc.nextLine();
	for(int i=0;i<sl;i++)
	{
		System.out.println("Nhập mã NV:");
		String maNv=sc.nextLine();
		maNv=check(maNv);
		if (kiemTraTrungMa(maNv)) {
            System.out.println("Mã nhân viên " + maNv + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
            i--; 
            continue; 
        }
		System.out.println("Nhập họ tên:");
		String hoTen=sc.nextLine();
		hoTen=check(hoTen);
		System.out.println("Nhập tuổi:");
		int tuoi=sc.nextInt();
		tuoi=check(tuoi);
		sc.nextLine();
		System.out.println("Nhập chức vụ:");
		String chucVu=sc.nextLine();
		chucVu=check(chucVu);
		System.out.println("Nhập lương:");
		float luong=sc.nextFloat();
		luong=check(luong);
		sc.nextLine();
		NhanVien nv=new NhanVien(hoTen,tuoi,maNv,luong,chucVu);
		dsnv.add(nv);
	}
	obj.ghiFile(dsnv);
}
public void timKiemTheoTen() {
    System.out.println("Nhập tên nhân viên cần tìm kiếm:");
    String tenCanTim = sc.nextLine();
    tenCanTim = check1(tenCanTim);

    boolean found = false;

    System.out.println("					+--------------+----------------+------+-----------+------------+");
    System.out.println("					| Mã nhân viên |   Họ và tên    | Tuổi | Chức vụ   | Lương      |");
    System.out.println("					+--------------+----------------+------+-----------+------------+");

    for (NhanVien nv : dsnv) {
        if (nv.getHoTen().equalsIgnoreCase(tenCanTim)) {
            System.out.printf("					| %-12s | %-13s  | %-4d | %-9s | %-10.3f |\n",
                    nv.getMaNV().toUpperCase(), nv.getHoTen().toUpperCase(),
                    nv.getTuoi(), nv.getChucVu().toUpperCase(), nv.getLuong());
            found = true;
        }
    }

    if (!found) {
        System.out.println("					Không tìm thấy nhân viên với tên: " + tenCanTim);
    }

    System.out.println("					+--------------+----------------+------+-----------+------------+");
}
public void sapXepTheoTen() {
    Collections.sort(dsnv, new Comparator<NhanVien>() {
        @Override
        public int compare(NhanVien nv1, NhanVien nv2) {
            return nv1.getHoTen().compareToIgnoreCase(nv2.getHoTen());
        }
    });

    System.out.println("					+--------------+----------------+------+-----------+------------+");
    System.out.println("					| Mã nhân viên |   Họ và tên    | Tuổi | Chức vụ   | Lương      |");
    System.out.println("					+--------------+----------------+------+-----------+------------+");

    for (NhanVien nv : dsnv) {
        System.out.printf("					| %-12s | %-13s  | %-4d | %-9s | %-10.3f |\n",
                nv.getMaNV().toUpperCase(), nv.getHoTen().toUpperCase(),
                nv.getTuoi(), nv.getChucVu().toUpperCase(), nv.getLuong());
    }

    System.out.println("					+--------------+----------------+------+-----------+------------+");
}


public boolean kiemTraTrungMa(String maNv) {
    for (NhanVien nv : dsnv) {
        if (nv.getMaNV().equalsIgnoreCase(maNv)) {
            return true; 
        }
    }
    return false; 
}

public void docFile() {
	dsnv= obj.docFile("f:\\dsnv.txt");
}

public void hienthi()
{
	docFile();
System.out.println("					+--------------+----------------+------+-----------+------------+");
System.out.println("					| Mã nhân viên |   Họ và tên    | Tuổi | Chức vụ   | Lương      |");
System.out.println("					+--------------+----------------+------+-----------+------------+");

for (NhanVien nv : dsnv) 
{
    System.out.printf("					| %-12s | %-13s  | %-4d | %-9s | %-10.3f |\n", nv.getMaNV().toUpperCase(), nv.getHoTen().toUpperCase(), nv.getTuoi(), nv.getChucVu().toUpperCase(), nv.getLuong());
}
System.out.println("					+--------------+----------------+------+-----------+------------+");
}

public void hienthi1()
{
	docFile();
System.out.println("					+--------------+----------------+------+-----------+------------+");
System.out.println("					| Mã nhân viên |   Họ và tên    | Tuổi | Chức vụ   | Lương      |");
System.out.println("					+--------------+----------------+------+-----------+------------+");

for (NhanVien nv1 : dsnv) 
{
    System.out.printf("					| %-12s | %-13s  | %-4d | %-9s | %-10.3f |\n", nv1.getMaNV().toUpperCase(), nv1.getHoTen().toUpperCase(), nv1.getTuoi(), nv1.getChucVu().toUpperCase(), nv1.getLuong());
}
System.out.println("					+--------------+----------------+------+-----------+------------+");
}
public void hienThiDK(float luong1)
{
	System.out.println("					+--------------+----------------+------+-----------+------------+");
	System.out.println("					| Mã nhân viên |   Họ và tên    | Tuổi | Chức vụ   | Lương      |");
	System.out.println("					+--------------+----------------+------+-----------+------------+");


	for(NhanVien nv:dsnv)
	{ if(nv.getLuong()>=luong1)
	{
	    System.out.printf("					| %-12s | %-13s  | %-4d | %-9s | %-10.3f |\n", nv.getMaNV().toUpperCase(), nv.getHoTen().toUpperCase(), nv.getTuoi(), nv.getChucVu().toUpperCase(), nv.getLuong());
	
	System.out.println("					+--------------+----------------+------+-----------+------------+");
	}
	}
	}

public void themNhanvien(){
	
	for(int i=0;i<1;i++)
	{
		System.out.printf("					Nhập mã NV:");
		String maNv=sc.nextLine();
		maNv=check(maNv);
		if (kiemTraTrungMa(maNv)) {
            System.out.println("					Mã nhân viên " + maNv + " đã tồn tại trong danh sách. Vui lòng nhập lại.");
            i--; 
            continue; 
        }
		System.out.printf("					Nhập họ tên:");
		String hoTen=sc.nextLine();
		hoTen=check(hoTen);
		System.out.printf("					Nhập tuổi:");
		int tuoi=sc.nextInt();
		tuoi=check(tuoi);
		sc.nextLine();
		System.out.printf("					Nhập chức vụ:");
		String chucVu=sc.nextLine();
		chucVu=check(chucVu);
		System.out.printf("					Nhập lương:");
		float luong=sc.nextFloat();
		luong=check(luong);
		sc.nextLine();
		NhanVien nv=new NhanVien(hoTen,tuoi,maNv,luong,chucVu);
		dsnv.add(nv);
	}
	obj.ghiFile(dsnv);
}

public void xoa(String nv) {
for(int i=0; i<dsnv.size();i++)
{
	if(dsnv.get(i).getMaNV().equals(nv)==true)
		dsnv.remove(i);
}
obj.ghiFile(dsnv);
}
public void hienThiLonNhat() {
	float max=0;
	    for (NhanVien nv: dsnv) {
	        if (max <nv.getLuong())max=nv.getLuong() ;
	    }
	     for (NhanVien nv:dsnv) {
	    	 if(nv.getLuong()==max) {
	    		 System.out.println("					+--------------+----------------+------+-----------+------------+");
	    		 System.out.println("					| Mã nhân viên |   Họ và tên    | Tuổi | Chức vụ   | Lương      |");
	    		 System.out.println("					+--------------+----------------+------+-----------+------------+");
	    			    System.out.printf("					| %-12s | %-13s  | %-4d | %-9s | %-10.3f |\n", nv.getMaNV().toUpperCase(), nv.getHoTen().toUpperCase(), nv.getTuoi(), nv.getChucVu().toUpperCase(), nv.getLuong());
	    			
	    			System.out.println("					+--------------+----------------+------+-----------+------------+");
	    	 }
	        }
	     obj.ghiFile(dsnv);
}


public void capNhatThongTinNhanVien(String maNv) {
    boolean found = false;

    for (NhanVien nv : dsnv) {
        if (nv.getMaNV().equalsIgnoreCase(maNv)) {
            found = true;

            System.out.println("					Nhập thông tin cập nhật cho nhân viên " + maNv + ":");

            System.out.print("					Họ tên mới: ");
            String hoTenMoi = sc.nextLine();
            hoTenMoi = check1(hoTenMoi);

            System.out.print("					Tuổi mới: ");
            int tuoiMoi = sc.nextInt();
            tuoiMoi = check(tuoiMoi);
            sc.nextLine();

            System.out.print("					Chức vụ mới: ");
            String chucVuMoi = sc.nextLine();
            chucVuMoi = check2(chucVuMoi);

            System.out.print("					Lương mới: ");
            float luongMoi = sc.nextFloat();
            luongMoi = check(luongMoi);
            sc.nextLine();

           
            nv.setHoTen(hoTenMoi);
            nv.setTuoi(tuoiMoi);
            nv.setChucVu(chucVuMoi);
            nv.setLuong(luongMoi);

            System.out.printf("					Thông tin nhân viên " + maNv + " đã được cập nhật.");
            break; 
        }
    }

    if (!found) {
        System.out.printf("					Không tìm thấy nhân viên với mã: " + maNv);
    }

    obj.ghiFile(dsnv);
}
	public String check(String maNv) {
	
		while (true)
		{
			try {
				if(maNv.length()!=0) break;
				else {
					System.out.println("					Không được trống");
					System.out.printf("					Nhập lại:");
					maNv=sc.nextLine();
				}
				
			}catch(Exception e) {
				System.out.print("					Bạn đã nhập sai(Mã NV trống");}
			
		} return(maNv);
	}


public String check1(String hoTen) {

	while (true)
	{
		try {
			if(hoTen.length()!=0) break;
			else {
				System.out.println("					Không được trống");
				System.out.printf("					Nhập lại:");
				hoTen=sc.nextLine();
			}
			
		}catch(Exception e) {
			System.out.print("					Bạn đã nhập sai(Họ tên trống");}
		
	} return(hoTen);
}
public String check2(String chucVu) {

	while (true)
	{
		try {
			if(chucVu.length()!=0) break;
			else {
				System.out.println("					Không được trống");
				System.out.print("					Nhập lại:");
				chucVu=sc.nextLine();
			}
			
		}catch(Exception e) {
			System.out.print("					Bạn đã nhập sai(Chức vụ trống");}
		
	} return(chucVu);
}

public int check(int tuoi) {
	while(true)
	{
		try {
			if((tuoi>18) && (tuoi<=50)) break;
			else {
				System.out.println("					Tuổi không hợp lệ");
				System.out.print("					Nhập lại:");
				tuoi=sc.nextInt();
			}
		}catch(Exception e) {
			System.out.print("					Bạn đã nhập sai(Tuổi  trống");}
		
	} return(tuoi);

}
public Float check (Float luong) {
	while(true)
	{
		try {
			if(luong>=1000) break;
			else {
				System.out.println("					Lương không hợp lệ");
				System.out.print("						Nhập lại:");
				luong=sc.nextFloat();
			}
		}catch(Exception e) {
			System.out.print("					Ban da nhap sai(Luong ban Null");}
		
	} return (luong);

}

}
    







