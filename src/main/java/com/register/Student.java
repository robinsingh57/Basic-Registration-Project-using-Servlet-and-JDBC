package com.register;

import java.sql.Date;

public class Student {

	private String Id;
	private String name;
	private String city;
	private String email;
	private Date doe;
	private String course;

	public Student() {
		System.out.println("Default : Student");
	}

	public Student(String id, String name, String city, String email, Date doe, String course) {
		super();
		Id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.doe = doe;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", city=" + city + ", email=" + email + ", doe=" + doe
				+ ", course=" + course + "]";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
