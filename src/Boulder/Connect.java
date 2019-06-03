package Boulder;



import java.io.IOException;
import java.sql.*;
public class Connect {

	private Connection myConn;
	
	public void main(String[] args) {
		
	}
	
	public String lvl1() throws SQLException  {
		String str = "";
		myConn = DriverManager.getConnection("jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement myState = myConn.createStatement();
		ResultSet myRes = myState.executeQuery("CALL LVL1");
		while (myRes.next()) {
			str += myRes.getString("LVL");
			

		}
	
		return str ; 
		
	}
	public String lvl2() throws SQLException {
		String str = "";
		myConn = DriverManager.getConnection("jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement myState = myConn.createStatement();
		ResultSet myRes = myState.executeQuery("CALL LVL2");
		while (myRes.next()) {
			str += myRes.getString("LVL");
		}
		
		return str;
	}
	public String lvl3() throws SQLException, IOException {
		
		String str = "";
		myConn = DriverManager.getConnection("jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement myState = myConn.createStatement();
		ResultSet myRes = myState.executeQuery("CALL LVL3");
		while (myRes.next()) {
			str += myRes.getString("LVL");

		}
		

				return str;
	}
	public String lvl4() throws SQLException {
		String str = "";
		myConn = DriverManager.getConnection("jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement myState = myConn.createStatement();
		ResultSet myRes = myState.executeQuery("CALL LVL4");
		while (myRes.next()) {
			str += myRes.getString("LVL");
		}
		
		return str;
	}
	public String lvl5() throws SQLException {
		String str = "";
		myConn = DriverManager.getConnection("jdbc:mysql://localhost/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement myState = myConn.createStatement();
		ResultSet myRes = myState.executeQuery("CALL LVL5");
		while (myRes.next()) {
			str += myRes.getString("LVL");
		}
		
		return str;
	}
	

}
		