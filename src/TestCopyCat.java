import java.io.File;

import hk.edu.csids.copycat.*;

public class TestCopyCat {

	static public void main(String args[]){
		File file = new File(
				"d:/test.xlsx");
		
		String writePath = "D:/";
		CopyCat cc;
		cc = new CopyCat(file, writePath);
	} //end main()
}