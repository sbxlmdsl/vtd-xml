/**
 * This is a demonstration of how to use the extended VTD parser
 * to process large XML file. 
 */
import com.ximpleware.extended.*;
public class mem_mapped_read {
	/* first read is the longer version of loading the XML file */
	public static void first_read() throws Exception{
	XMLMemMappedBuffer xb = new XMLMemMappedBuffer();
        VTDGenHuge vg = new VTDGenHuge();
        xb.readFile("test.xml");
        vg.setDoc(xb);
        vg.parse(true);
        VTDNavHuge vn = vg.getNav();
        System.out.println("text data ===>" + vn.toString(vn.getText()));
	}	

	/* second read is the shorter version of loading the XML file */
	public static void second_read() throws Exception{
	    VTDGenHuge vg = new VTDGenHuge();
	    if (vg.parseFile("test.xml",true,VTDGenHuge.MEM_MAPPED)){
	        VTDNavHuge vn = vg.getNav();
	        System.out.println("text data ===>" + vn.toString(vn.getText()));
	    }
	}

	public static void main(String[] s) throws Exception{
		first_read();
	 	second_read();
	}
}

