package jdbctemplate;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Testjdbctemplate {
	 
	public static void main(String[] args) throws SQLException {

	        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

	        dataSource.setDriver(new com.mysql.jdbc.Driver());
	        dataSource.setUrl("jdbc:mysql://localhost:3306/submexch");
	        dataSource.setUsername("root");
	        dataSource.setPassword("subex");

	        String sql = "SELECT email FROM tbluser WHERE user_id=?";
	        List<Object[]> emails = new ArrayList<>();
		    emails.add((new Object[] {1}));
		  //  emails.add((new Object[] {2}));

	        JdbcTemplate jtm = new JdbcTemplate(dataSource);

	        List<Map<String,Object>> list = jtm.queryForList(sql, emails.toArray());

	        for(Map<String,Object> map : list) {
	        	System.out.println(map.get("email"));
	        }
	    }
	
}
