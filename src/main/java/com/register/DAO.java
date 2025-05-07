package com.register;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface DAO {

	public String getCustomId();

	public void registerStudent(Student stud);

	public boolean checkEmailForRegister(String email) throws ClassNotFoundException, SQLException;

	public boolean checkEmailForViewData(String email) throws ClassNotFoundException, SQLException;

	public boolean checkIdForViewData(String id) throws ClassNotFoundException, SQLException;

	public Student getById(String id) throws ClassNotFoundException, SQLException;

	public List<Student> getByCourse(String course) throws ClassNotFoundException, SQLException;

	public Student getListStudent(ResultSet set) throws SQLException;

	public boolean deleteStudentById(String Id) throws ClassNotFoundException, SQLException;

	public List<Student> getAllStudent() throws ClassNotFoundException, SQLException;

	public List<Student> getByDate(String starting, String ending) throws ClassNotFoundException, SQLException;
	
	public String  updateStudent(Student s1) throws ClassNotFoundException, SQLException;

}