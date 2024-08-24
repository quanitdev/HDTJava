package DAC;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	CacMenu menu=new CacMenu();
	Scanner sc=new Scanner(System.in);
	int chon;
	do {
		System.out.println("							============QUẢN LÍ NHÀ HÀNG=============");
		System.out.println("							|| 		1. Nhân Viên           ||");
		System.out.println("							|| 		2. Menu                ||");
		System.out.println("							|| 		3. Khách hàng          ||");
		System.out.println("							|| 		4. Hóa Đơn             ||");
		System.out.println("							=========================================");
		System.out.println("							-> Mời bạn chọn: ");
		chon=sc.nextInt();
		switch(chon)
		{
		case 1:{ menu.menuNv();break;}
		case 2:{ menu.menumn();break;}
		case 3:{ menu.menuKh();break;}
		case 4:{ menu.menuhd();break;}
		default: break;
		}
		
	}while(chon<=3);
}
}
