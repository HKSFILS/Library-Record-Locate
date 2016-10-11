import hk.edu.csids.bookquery.*;
import hk.edu.csids.*;

public class TestZ3950earchByISBN{
	public static void main(String[] args){
		
		String inst = "CAMBRI";
		String isbn = "7224043095";
		//String isbn = "781058703X";
		CJKStringHandling ch = new CJKStringHandling();
		
		try{
			if(args[0]!=null){inst=args[0];}
		} // try
		
		catch (Exception e){System.out.println("No inst Argument, using default. Syntax: [ccommand] [inst] [inbn]");}
		try{
			if(args[1]!=null){isbn=args[1];}
		} //end try
		catch (Exception e){System.out.println("No ISBN Argument, using default. Syntax: [ccommand] [inst] [inbn]");}
		Z3950QueryByISBN q = new Z3950QueryByISBN(isbn, inst);
		if(q.match()){
			System.out.println("MATCH: ");
			System.out.println("Query String:" + q.getQueryStr());
			System.out.println(q.getQueryBase());
			System.out.println("--- ");
			System.out.println(ch.convertToTradChinese(q.bk.marc.getMarcTag()));
			System.out.println("--- ");
			System.out.println("Book info:" + q.bk.toString());
			System.out.println(q.bk.getHoldingText());
			System.out.println("AVA:" + q.isAva());
			System.out.println("BIB:" + q.getBib_no());
			System.out.println("EXT ITM:" + q.getExt_itm_no());
			System.out.println("AVA ITM:" + q.getAva_itm_no());
		} else {
			System.out.println("NOT MATCH: ");
			System.out.println("Query String:" + q.getQueryStr());
			System.out.println(q.getQueryBase());
			System.out.println("--- ");
			System.out.println(q.getResult());
			System.out.println("--- ");
		} //end if
	} //end main()
} //end class Test