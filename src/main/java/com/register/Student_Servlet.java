package com.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "student", urlPatterns = { "/registerStudent.com", "/StudentLogin.com" })
public class Student_Servlet extends HttpServlet {

	public void init(ServletConfig sc) {
		System.out.println("ServletConfig()....");
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//=========================================================================================================================
		// Register new Student
		String url = req.getRequestURI();
		DAO dao = new DAO_Service();

		if (url.equals("/Student_Registration_Managment/registerStudent.com")) {
			try {
				// Check Email..................................
				String emailCheck = req.getParameter("email");
				boolean b = dao.checkEmailForRegister(emailCheck);
				if (b) {
					String id = dao.getCustomId();
					String name = req.getParameter("name");
					String city = req.getParameter("city");
					String email = req.getParameter("email");

					LocalDate now = LocalDate.now();
					Date date = Date.valueOf(now);
					String courses[] = req.getParameterValues("course");
					String course = String.join(",", courses);

					// Add Student
					Student s1 = new Student(id, name, city, email, date, course);
					dao.registerStudent(s1);

					String page = "Student_Login.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);
				} else {
					String msg = "This email id already used.";
					req.setAttribute("dublicate", msg);
					String page = "Register_Form.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//====================================================================================================================
		// For Login and View Data
		else if (url.equals("/Student_Registration_Managment/StudentLogin.com")) {
			try {
				String o = req.getParameter("otp");
				Integer otp = Integer.parseInt(o);
				Integer otp1 = 148400;

				String email = req.getParameter("email");
				boolean b = dao.checkEmailForViewData(email);

				// If all correct then query run
				if ((b) && (otp.equals(otp1))) {

					Connection con = ConnectionBuild.getConnection();
					String sql = "select * from Students where Email=(?);";
					PreparedStatement pre = con.prepareStatement(sql);
					pre.setString(1, email);
					ResultSet set = pre.executeQuery();

					Student s1 = null;
					while (set.next()) {
						String id = set.getString(1);
						String name = set.getString(2);
						String city = set.getString(3);
						String emails = set.getString(4);
						Date doe = set.getDate(5);
						String course = set.getString(6);
						s1 = new Student(id, name, city, emails, doe, course);
					}

					String page = "";
					req.setAttribute("STUDENT", s1);

					page = "show_Data.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);

					con.close();
					pre.close();
				} else {
					String msg = "You are enter incorrect email or otp. Please enter a correct email and otp.";
					req.setAttribute("MSG", msg);
					String page = "Student_Login.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void destroy() {
		System.out.println("Destroy()....");
	}

}
