package me.aslukili.letsgojakarta;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import me.aslukili.letsgojakarta.dao.BilliardsTableDao;
import me.aslukili.letsgojakarta.entities.BilliardsTable;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
  private String message;

  public void init() {
    message = "Hello World!";



  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    BilliardsTableDao billiardsTableDao = new BilliardsTableDao();
    billiardsTableDao.saveBilliardsTable(new BilliardsTable(1, "table l3adab"));

    // Hello
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>" + message + "</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}
