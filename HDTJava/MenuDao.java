
package DAC;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class MenuDao {

	
	public void ghiFile(ArrayList<Menu> dstd) {
		 FileOutputStream fout = null;
	        ObjectOutputStream oos = null;
	        try {
	            fout = new FileOutputStream("f:\\dstd.bin");
	            oos = new ObjectOutputStream(fout);
	            oos.writeObject(dstd);
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
	 
	public ArrayList<Menu> docFile(String filename) {

	    ArrayList<Menu> dstd = new ArrayList<>();



	    FileInputStream fin = null;
	    ObjectInputStream ois = null;
	    try {
	        fin = new FileInputStream(filename);
	        ois = new ObjectInputStream(fin);
	        dstd = (ArrayList<Menu>) ois.readObject();
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
	    return dstd;
	}
}
