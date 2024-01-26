package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mavenproject.Student;

@Component
public class jdbc implements ijdbc{
	@Autowired()
	private JdbcTemplate jdbctemp;
	
	public JdbcTemplate getjdbctemp() {
		return jdbctemp;
	}

	public void setjdbctemp(JdbcTemplate temp) {
		this.jdbctemp = temp;
	}

	public int insert(Student s) {
		String q="insert into Student value(?,?,?)";
		int r = this.jdbctemp.update(q,s.getID(),s.getName(),s.getCity());
		return r;
	}
	
	public int update(Student st) {
		String q="UPDATE Student SET NAME=?,City=? WHERE id=?;";
		int r=jdbctemp.update(q,st.getName(),st.getCity(),st.getID());
		return r;
	}
	
	public int delete(int ID) {
		String q="DELETE FROM Student WHERE ID=?;";
		int r=jdbctemp.update(q,ID);
		return r;
	}


	public Student getDetail(int ID) {
		
		String q="SELECT * FROM Student WHERE ID=?;";
		Student s=jdbctemp.queryForObject(q,new ImpRowMapper(),ID);
		return s;
	}

	
	public List<Student> getAllDetail() {
		String q="SELECT * FROM Student;";
		List<Student> s=jdbctemp.query(q,new ImpRowMapper());
		return s;
	}
	

}
