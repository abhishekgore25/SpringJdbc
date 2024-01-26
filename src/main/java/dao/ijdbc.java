package dao;


import java.util.List;

import com.mavenproject.Student;

public interface ijdbc {

	int insert(Student s);
	
	int update(Student st);
	
	int delete(int ID);
	
	Student getDetail(int ID);
	
	List<Student> getAllDetail();
}
