import java.sql.Connection;
import java.sql.DriverManager;


public class oracletest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","y01","123456");
		System.out.println(con);
		
		
		
	}

}
