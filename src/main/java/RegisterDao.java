import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class RegisterDao {
	private String url="jdbc:mysql://localhost:3306/userdb";
	private String user="root";
    private String password="Bhanu@000";
    private String dbdriver="com.mysql.cj.jdbc.Driver";
    public void loadDriver(String dbdriver)
    {
    	try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Connection getConnection()
    {
    	Connection con=null;
    	try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
    }
    public String insert(Member member) 
    {
    	loadDriver(dbdriver);
    	Connection con=getConnection();
    	String result="Data entered successfully";
    	String sql="insert into userdb.member values(?,?)";
    	try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Data not entered";
		}
		return result;
    	
    }
}
