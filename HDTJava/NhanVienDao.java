package DAC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NhanVienDao {
	public void ghiFile(ArrayList<NhanVien> dsnv) {
		 FileOutputStream fout = null;
	        ObjectOutputStream oos = null;
	        try {
	            fout = new FileOutputStream("F:\\dsnv.txt");
	            oos = new ObjectOutputStream(fout);
	            oos.writeObject(dsnv);
	            System.out.println("Da luu File!");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (fout != null) {
	                try {
	                    fout.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (oos != null) {
	                try {
	                    oos.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	 
	public ArrayList<NhanVien> docFile(String filename) {

	    ArrayList<NhanVien> dsnv = new ArrayList<>();



	    FileInputStream fin = null;
	    ObjectInputStream ois = null;
	    try {
	        fin = new FileInputStream(filename);
	        ois = new ObjectInputStream(fin);
	        dsnv = (ArrayList<NhanVien>) ois.readObject();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (fin != null) {
	            try {
	                fin.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        if (ois != null) {
	            try {
	                ois.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return dsnv;
	}
}
