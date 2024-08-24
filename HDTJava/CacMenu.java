package DAC;

import java.util.ArrayList;
import java.util.Scanner;
public class CacMenu {
	
	QuanLiMenu obj = new QuanLiMenu();
	QuanLiNhanVien nvobj = new QuanLiNhanVien();
	QuanLiKhachHang khobj = new QuanLiKhachHang();
	QuanLiHoaDon hdobj = new QuanLiHoaDon();
	Scanner sc = new Scanner(System.in);
	
	
	
	public void menuNv() {
		
		int c1;
		do {
			System.out.println("							==========LÀM VIỆC VỚI NHÂN VIÊN===========");
			System.out.println("							|| 1. Nhập thông tin nhân viên            ||");
			System.out.println("							|| 2. Hiển thị nhân viên                  ||");
			System.out.println("							|| 3. Hiển thị lương theo yêu cầu         ||");
			System.out.println("							|| 4. Thêm nhân viên                      ||");
			System.out.println("							|| 5. Tìm kiếm theo tên                   ||");
			System.out.println("							|| 6. Sắp xếp theo tên                    ||");
			System.out.println("							|| 7. Xóa nhân viên theo mã               || ");
			System.out.println("							|| 8. Hiển thị nhân viên có lương cao nhất|| ");
			System.out.println("							|| 9. Sửa thông tin nhân viên             || ");
			System.out.println("							===========================================");
			System.out.printf("	         					 -> Moi ban chon:");
			c1 = sc.nextInt();
			switch (c1) {
			case 1: {
				
				nvobj.nhap();
				
				break;
			}
			case 2: {
				nvobj.hienthi();
				break;
			}
			case 3: {
				System.out.print("					Nhập lương cần tìm:");
				float luong1=sc.nextFloat();
				nvobj.hienThiDK(luong1);
				break;
			}
			case 4:{
				
				nvobj.themNhanvien();
				nvobj.hienthi();
			    break;
			}
			case 5:{
				nvobj.timKiemTheoTen();
				break;
			}
			
			case 6:
			{
				nvobj.sapXepTheoTen();
				break;
			}
			case 7:
			{
				System.out.println("					Nhập mã nhân viên cần xóa:");
				sc.nextLine();
				String nvien=sc.nextLine();
				nvobj.xoa(nvien);
				nvobj.hienthi();
				break;
			}
			case 8:{
				System.out.println("					Nhân viên có lương cao nhất::");
				nvobj.hienThiLonNhat();
		
				break;
			}
			case 9:{
				System.out.print("					Nhập mã nhân viên cần sửa:");
				sc.nextLine();
				String maNv =sc.nextLine();
				nvobj.capNhatThongTinNhanVien(maNv);
				nvobj.hienthi();
				break;
			}
			
			default:
				break;
			}
		} while (c1 <=9 );
	}

	public void menumn() {
		int c2;
		do {
			System.out.println("							============LÀM VIỆC VỚI MENU=============");
			System.out.println("							|| 1. Đọc File				||");
			System.out.println("							|| 2. Hiển thị Menu			||");
			System.out.println("							|| 3. Hiển thị giá  theo yêu cầu	||");
			System.out.println("							|| 4. Chèn tên món			||");
			System.out.println("							|| 5. Tìm kiếm tên món                  ||");
			System.out.println("							|| 6. Xóa tên món			||");
			System.out.println("							==========================================");
			System.out.printf("								-> Mời bạn chọn	:");
			c2 = sc.nextInt();
			switch (c2) {
			case 1: {
				obj.khoiTao();
				obj.docFile();
				break;
			}
			case 2: {
				obj.hienthi();
				break;
			}
			case 3: {
				System.out.print("Nhập giá cần tìm:");
				float gia1=sc.nextFloat();
				obj.hienThiDK(gia1);
				break;
			}
			case 4: {
				obj.themMonAn();
				obj.hienthi();
				break;
			}
			case 5:{
				obj.timKiemTheoTen();
				break;
			}
			case 6:
			{
				System.out.println("Nhập mã món cần xóa:");
				sc.nextLine();
				String ma=sc.nextLine();
				obj.xoa(ma);
				obj.hienthi();
			}
			default:
				break;
			}
		} while (c2 <= 6);
	}

	public void menuKh() {
		int c3;
		do {
			System.out.println("							==========LÀM VIỆC VỚI KHÁCH HÀNG===========");
			System.out.println("							|| 1. Nhập thông tin khách hàng:          ||");
			System.out.println("							|| 2. Hiển thị khách hàng                 ||");
			System.out.println("							|| 3. Chèn khách hàng                     ||");
			System.out.println("							|| 4. Tìm kiếm theo tên                   ||");
			System.out.println("							|| 5. Tìm kiếm theo số lượng              ||");
			System.out.println("							|| 6. Sắp xếp theo tên                    ||");
			System.out.println("							|| 7. Xóa khách hàng theo mã              || ");
			System.out.println("							|| 8. Hiển thị khách hàng đặt nhiều món   ||");
			System.out.println("							============================================");
			System.out.println("							-> Mời bạn chọn:");
			c3 = sc.nextInt();
			switch (c3) {
			case 1: {
				khobj.nhap();
				break;
			}
			case 2: {
				khobj.hienthi();
				break;
			}
			case 3: {
				khobj.themKhachHang();
				khobj.hienthi();
		break;
	}
			case 4:{
				khobj.timKiemTheoTen();
				break;
			}
			
			case 5: {
				System.out.print("Nhập số lượng cần tìm:");
				int sl1=sc.nextInt();
				khobj.hienThiDK(sl1);
				break;
			}
			case 6:
			{
				khobj.sapXepTheoTen();
				break;
			}
			case 7:
	{
		System.out.println("Nhập mã khách hàng cần xóa:");
		sc.nextLine();
		String kh=sc.nextLine();
		khobj.xoa(kh);
		khobj.hienthi();
		break;
	}
			
			case 8:{
		System.out.println(" Khách hàng đặt nhiều món:");
		khobj.hienThiLonNhat();
		
		break;
	}
			default:
				break;
			}
		} while (c3 < 9);
	}
	
public void menuhd() {
		
		int c4;
		do {
			System.out.println("							==========LÀM VIỆC VỚI HÓA ĐƠN==========");
			System.out.println("							|| 1. Nhập hóa đơn                    ||");
			System.out.println("							|| 2. Hiển thị hóa đơn                ||");
			System.out.println("							|| 3. Hiển thị thành tiền theo yêu cầu||");
			System.out.println("							|| 4. Xóa HD theo maHD                || ");
			System.out.println("							|| 5. Tìm kiếm theo mã                || ");
			System.out.println("							|| 6. Hiển thị HD lớn nhất            || ");
			System.out.println("							=======================================");
			System.out.println("							-> Mời bạn chọn:");
			c4 = sc.nextInt();
			switch (c4) {
			case 1: {
				hdobj.nhap();
				break;
			}
			case 2: {
				hdobj.hienthi();
				break;
			}
			case 3: {
				System.out.print("Nhập thành tiền cần tìm::");
				float thanhtien1=sc.nextFloat();
				hdobj.hienThiDK(thanhtien1);
				
				break;
			}
			
			case 4:
			{
				System.out.println("NHập mã hóa đơn cần xóa:");
				sc.nextLine();
				String hdon=sc.nextLine();
				hdobj.xoa(hdon);
				hdobj.hienthi();
				break;
			}
			case 5:{
				hdobj.timKiemTheoMa();
				break;
			}
			case 6:{
				System.out.println(" Hóa đơn cao nhất:");
				hdobj.hienThiLonNhat();
				break;
			}
			default:
				break;
			}
		} while (c4 <7 );
	}
	
}
