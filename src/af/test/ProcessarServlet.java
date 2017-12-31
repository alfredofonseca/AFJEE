package af.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import af.test.entity.Customer;
import af.test.service.CustomerEJB;


@WebServlet("/processar")
public class ProcessarServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CustomerEJB ejb;
	
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inicio executar servlet");
		PrintWriter writer = response.getWriter();
		
		
		Integer pId = Integer.parseInt(request.getParameter("id"));
		String pFirstname = request.getParameter("firstname");
		String pLastname = request.getParameter("lastname");
		
		


		Customer customer = ejb.ler(pId);
		
		customer.setFirstname(pFirstname);
		customer.setLastname(pLastname);
		
		ejb.processar(customer);
		
		
		
		writer.append("<html> Customer processed! <br/>");
		
		writer.append("<hr/>");
		writer.append("Parametros: <br/>");
		writer.append("id:"+pId+"<br/>");
		writer.append("firstname:"+pFirstname+"<br/>");
		writer.append("lastname:"+pLastname+"<br/>");

		
		writer.append("<hr/>");
		writer.append("See the alteration after merge (inside tx) affected state");
		Customer state = ejb.ler(pId);
		writer.append("Estado: <br/>");
		writer.append(state+"<br/>");
		
		writer.append("</html>");
		
	}
	

}
