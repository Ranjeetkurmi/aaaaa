import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	
	static String Q="select * from PRODUCTS";
	

	public static void main(String[] args) {
	   
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String userName="scott";
			String password="tiger";
		Connection con=DriverManager.getConnection(url,userName,password);
		
		
		if(con!=null) {
			System.out.println("connection successfull");
		}
		else {
			System.out.println("Connection Refsued");
		}
		java.sql.Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(Q);
	   String I="insert into PRODUCTS values ('SDsS','TY','YHU',90)";
		stm.executeUpdate(I);
		System.out.println("inserted");
		
		
		
		
		while(rs.next()) {
			System.out.print(rs.getString("PROD_ID"));
			System.out.print(rs.getString("PROD_NAME"));
			System.out.print(rs.getString("PROD_DESC"));
			System.out.println(rs.getInt("PRICE"));
		}
		
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
