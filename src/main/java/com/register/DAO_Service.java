package com.register;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAO_Service implements DAO {

	// Custom Student ID
	@Override
	public String getCustomId() {
		String st = "JTC-";
		try {
			String q1 = "select count(*) as total from Students;";
			Connection con = ConnectionBuild.getConnection();
			PreparedStatement pre = con.prepareStatement(q1);
			ResultSet set = pre.executeQuery();
			set.next();
			int id = set.getInt("total") + 1;
			st = st + id;
			con.close();
			pre.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	// Adding Student
	@Override
	public void registerStudent(Student stud) {
		try {
			String sql = "insert into Students values(?,?,?,?,?,?);";
			Connection con = ConnectionBuild.getConnection();
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, stud.getId());
			pre.setString(2, stud.getName());
			pre.setString(3, stud.getCity());
			pre.setString(4, stud.getEmail());
			pre.setDate(5, stud.getDoe());
			pre.setString(6, stud.getCourse());
			pre.execute();

			con.close();
			pre.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Check Email for View Data
	public boolean checkEmailForViewData(String email) throws ClassNotFoundException, SQLException {

		String sql = "select count(*) from Students where Email=(?);";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, email);

		ResultSet set = pre.executeQuery();

		int ii = 0;
		if (set.next()) {
			ii = set.getInt(1);
		}
		if (ii > 0) {
			return true;
		} else {
			return false;
		}
	}

	// Check Id for view Data
	public boolean checkIdForViewData(String id) throws ClassNotFoundException, SQLException {

		String sql = "select count(*) from Students where ID=(?);";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, id);
		ResultSet set = pre.executeQuery();
		int ii = 0;
		if (set.next()) {
			ii = set.getInt(1);
		}
		if (ii > 0) {
			return true;
		} else {
			return false;
		}
	}

	// Check Email for Register Data
	public boolean checkEmailForRegister(String email) throws ClassNotFoundException, SQLException {

		String sql = "select count(*) from Students where EMAIL=(?);";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, email);

		ResultSet set = pre.executeQuery();

		int ii = 0;
		if (set.next()) {
			ii = set.getInt(1);
		}
		if (ii > 0) {
			return false;
		} else {
			return true;
		}
	}

// ================================= For Admin  ============================================================

	public Student getById(String id) throws ClassNotFoundException, SQLException {
		String sql = "select * from students where ID=(?);";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, id);
		ResultSet set = pre.executeQuery();

		Student s1 = null;
		while (set.next()) {
			String Id = set.getString(1);
			String name = set.getString(2);
			String city = set.getString(3);
			String email = set.getString(4);
			Date date = set.getDate(5);
			String course = set.getString(6);
			s1 = new Student(Id, name, city, email, date, course);
		}
		System.out.println(s1);
		pre.close();
		con.close();
		return s1;
	}

	// ======================= Get Student by Course ========================================

	public Student getListStudent(ResultSet set) throws SQLException {
		Student s1 = new Student();
		String Id = set.getString(1);
		String name = set.getString(2);
		String city = set.getString(3);
		String email = set.getString(4);
		Date date = set.getDate(5);
		String cours = set.getString(6);
		s1.setId(Id);
		s1.setName(name);
		s1.setCity(city);
		s1.setEmail(email);
		s1.setDoe(date);
		s1.setCourse(cours);
		return s1;
	}

	public List<Student> getByCourse(String course) throws ClassNotFoundException, SQLException {
		String sql = "select * from Students where COURSE like ?";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, "%" + course + "%");
		ResultSet set = pre.executeQuery();

		System.out.println("RS :" + set);

		List<Student> listStudent = new ArrayList<>();
		while (set.next()) {
			listStudent.add(getListStudent(set));
		}

		System.out.println("List Student :" + listStudent);

		pre.close();
		con.close();
		return listStudent;
	}

	public boolean deleteStudentById(String Id) throws ClassNotFoundException, SQLException {
		String sql = "delete from Students where ID=(?);";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, Id);
		int ii = pre.executeUpdate();
		if (ii > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Student> getAllStudent() throws ClassNotFoundException, SQLException {
		String sql = "select * from Students;";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		ResultSet set = pre.executeQuery();

		System.out.println("RS :" + set);

		List<Student> listStudent = new ArrayList<>();
		while (set.next()) {
			listStudent.add(getListStudent(set));
		}

		System.out.println("List Student :" + listStudent);

		pre.close();
		con.close();
		return listStudent;
	}

	public List<Student> getByDate(String starting, String ending) throws ClassNotFoundException, SQLException {
		String sql = "select * from Students where Date_of_Enrollment between ? and ?;";
		Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setDate(1, Date.valueOf(starting));
		pre.setDate(2, Date.valueOf(ending));
		ResultSet set = pre.executeQuery();

		System.out.println("RS :" + set);

		List<Student> listStudent = new ArrayList<>();
		while (set.next()) {
			listStudent.add(getListStudent(set));
		}

		System.out.println("List Student :" + listStudent);

		pre.close();
		con.close();
		return listStudent;
	}
	
	// For Updating Student to Database 
	public String  updateStudent(Student s1) throws ClassNotFoundException, SQLException {
String sql = "update Students set NAME = (?), CITY = (?), EMAIL = (?), Date_of_Enrollment = (?), COURSE = (?) where ID = (?);";
		System.out.println("In update method: "+s1);
	Connection con = ConnectionBuild.getConnection();
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, s1.getName());
		pre.setString(2, s1.getCity());
		pre.setString(3, s1.getEmail());
		pre.setDate(4, s1.getDoe());
		pre.setString(5, s1.getCourse());
		pre.setString(6, s1.getId());
		pre.executeUpdate();
		
		pre.close();
		con.close();
		return s1.getId();
	}

}
