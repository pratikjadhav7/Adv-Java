package Servelet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServelet extends HttpServlet {

	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	HttpSession session = req.getSession();
    	
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("Username = " + username);
        System.out.println("Password = " + password);

        if ("pratik".equals(username) && "12345".equals(password)) {
        	
        	User user = new User("Pratik","12345",123456789,"Pune",LocalDate.of(2026,4,4));
        	session.setAttribute("user",user);
        	
        	RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");//rd carrys both req & resp
        	//rd.forward(req, resp);
        	
        	rd.include(req, resp); //this method will also prints "After forward
        	resp.getWriter().print("After foward");
        	
       //     resp.sendRedirect("dashboard.jsp");
            
        } else {
        	session.setAttribute("errmsg","invalid username or pass");
            resp.sendRedirect("indexjsp.jsp");
        }
    }
}
