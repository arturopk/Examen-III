package examen.arturo;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.Webservlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
//@WebServlet("/Calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double result;

	public Calculadora() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String valueString = request.getParameter("value");
		String resultString = request.getParameter("result");

		double result = 0;
		if (!resultString.isEmpty()) {
			result = Double.parseDouble(resultString);
		}

		if (!valueString.isEmpty()) {

			double value = Double.parseDouble(valueString);

			Map parameters = request.getParameterMap();
			if (parameters.containsKey("plus")) {
				result += value;
			} else if (parameters.containsKey("minus")) {
				result -= value;
			} else if (parameters.containsKey("divide")) {
				result /= value;
			} else if (parameters.containsKey("multiply")) {
				result *= value;
			}

			request.setAttribute("value", result);

			RequestDispatcher view = request.getRequestDispatcher("/Calc.jsp");
			view.forward(request, response);

		}else {

			RequestDispatcher view = request.getRequestDispatcher("/Calc.jsp");
			view.forward(request, response);

		}
	}
}
