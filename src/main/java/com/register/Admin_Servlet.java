package com.register;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "admin", urlPatterns = { "/checkAdmin.com", "/ViewStudentById.com", "/ViewStudentByCourse.com",
		"/ViewStudentByDate.com", "/DeleteStudentById.com", "/ViewAllStudent.com", "/forEditForm.com",
		"/updateStudent.com", "/forDeleteStudent.com" })
public class Admin_Servlet extends HttpServlet {

	public void init(ServletConfig sc) {
		System.out.println("Servlet Config...");
	}

	public void service(HttpServletRequest req, HttpServletResponse res) {

		DAO dao = new DAO_Service();

		String url = req.getRequestURI();
		System.out.println(url);

		if (url.equals("/Student_Registration_Managment/checkAdmin.com")) {
			try {
				String user = "robin1484@gmail.com";
				String password = "Robin@5880";
				String user1 = req.getParameter("username");
				String pass = req.getParameter("password");
				if (user.equals(user1) && password.equals(pass)) {
					String page = "Admin_Pannel.jsp";

					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);
				} else {
					String msg = "Invalid login creditial";
					req.setAttribute("MSG", msg);
					String page = "AdminLoginPage.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//===================================== View Student by Id ================================================================
		else if (url.equals("/Student_Registration_Managment/ViewStudentById.com")) {
			try {
				String ids = req.getParameter("id");
				boolean b = dao.checkIdForViewData(ids);

				if (b) {
					Student stud = dao.getById(ids);
					System.out.println(stud);

					req.setAttribute("STUDENT", stud);

					String page = "show_Data.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(page);
					rd.forward(req, res);
				} else {
					String page = "ViewStudentId.jsp";
					String msg = "No Student found for this ID.";
					req.setAttribute("MSG", msg);
					req.getRequestDispatcher(page).forward(req, res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//================================= View Student by Course ==========================================================
		else if (url.equals("/Student_Registration_Managment/ViewStudentByCourse.com")) {
			try {
				String course = req.getParameter("course");
				List<Student> list = dao.getByCourse(course);

				req.setAttribute("STUDENT", list);
				String page = "showAllStudent.jsp";
				req.getRequestDispatcher(page).forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

// ===================================View Student by Date ============================================================
		else if (url.equals("/Student_Registration_Managment/ViewStudentByDate.com")) {
			String starting = req.getParameter("start");
			String ending = req.getParameter("end");
			try {
				List<Student> list = dao.getByDate(starting, ending);
				req.setAttribute("STUDENT", list);
				String page = "showAllStudent.jsp";
				req.getRequestDispatcher(page).forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
//====================================== Delete Student by Id =============================================================		
		else if (url.equals("/Student_Registration_Managment/DeleteStudentById.com")) {

			String Id = req.getParameter("id");
			try {
				boolean b = dao.checkIdForViewData(Id);
				if (b) {
					boolean bool = dao.deleteStudentById(Id);
					System.out.println("After method call: " + bool);

					String msg = "";
					String page = "";
					if (bool) {
						System.out.println("For msg  print : " + bool);

						msg = "Record deleted.";
						req.setAttribute("SUCCESS", msg);
						page = "show_msg.jsp";
						req.getRequestDispatcher(page).forward(req, res);

					}
				} else {
					String msg = "No data found.";
					req.setAttribute("MSG", msg);
					req.getRequestDispatcher("DeleteStudentId.jsp").forward(req, res);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//====================================== View All Student ===============================================================
		else if (url.equals("/Student_Registration_Managment/ViewAllStudent.com")) {
			try {
				List<Student> list = dao.getAllStudent();
				req.setAttribute("STUDENT", list);
				String page = "showAllStudent.jsp";
				req.getRequestDispatcher(page).forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//=================================== Getting ID for showing in Edit Form ====================================	

		else if (url.equals("/Student_Registration_Managment/forEditForm.com")) {
			try {
				String id = req.getParameter("id");
				Student student = dao.getById(id);
				req.setAttribute("STUDENT", student);

				req.getRequestDispatcher("EditForm.jsp").forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//=============================== For Update to Database ==================================================

		else if (url.equals("/Student_Registration_Managment/updateStudent.com")) {
			try {
				String id = req.getParameter("id");
				String name = req.getParameter("name");
				String city = req.getParameter("city");
				String email = req.getParameter("email");
				LocalDate now = LocalDate.now();
				Date date = Date.valueOf(now);

				String courses[] = req.getParameterValues("course");
				String course = String.join(",", courses);

				Student stud = new Student(id, name, city, email, date, course);
				String ID = dao.updateStudent(stud);

				Student student = dao.getById(ID);
				req.setAttribute("STUDENT", student);
				req.getRequestDispatcher("show_Data.jsp").forward(req, res);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//==========================For Delete Student===============================================================
		else if(url.equals("/Student_Registration_Managment/forDeleteStudent.com")){
			try {
				String id = req.getParameter("id");
					dao.deleteStudentById(id);
					List<Student> student = dao.getAllStudent();
					req.setAttribute("STUDENT", student);
					req.getRequestDispatcher("showAllStudent.jsp").forward(req, res);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
 
	}

	public void destroy() {
		System.out.println("Destroy....");
	}

}
