
package lab.mvc.controller;

import lab.mvc.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        Person person = new Person(firstName, lastName, birthDay, sex);

        request.setAttribute("person", person);

        int year = Integer.parseInt(birthDay);

        RequestDispatcher dispatcher;

        if (year < 1990) {
            dispatcher = getServletContext().getRequestDispatcher("/jsp/old.jsp");
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/jsp/young.jsp");
        }

        dispatcher.include(request, response);
    }
}
