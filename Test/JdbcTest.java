import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


public class JdbcTest {

	@Test
	public void test() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","y01","123456");
	System.out.println(con);
	String sql = "select * from tbl_user";
	PreparedStatement ps =con.prepareStatement(sql);
 ResultSet	rs = ps.executeQuery(sql);
 while(rs.next()){
		String sid = rs.getString(2);
		System.out.println(sid);
	}
 rs.close();
 ps.close();
 con.close();
		
//		fail("Not yet implemented");
	}

}




