package Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		//SimpleDateFormat sdf=new SimpleDateFormat("dd-MM月-yy hh.mm.ss.00000000 上午");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//String time=sdf.format(new Date());
		//System.out.println(time);
		String replace="2013-12-7.0.0. 0. 0";
		Date date=sdf.parse(replace);
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM月-yy hh.mm.ss.00000000 上午");
		String time=sdf1.format(date);
		System.out.println(time);
		
/*		
 * 			07-12月-13 12.00.00.000000 上午
		//times
		Timestamp ts=new Timestamp(System.currentTimeMillis());
	//	System.out.println(ts.toGMTString());
	
		System.out.println(Timestamp.valueOf("2013-12-7.0.0. 0. 0").toString());*/
	}

}
