package af.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import af.test.entity.Child;
import af.test.entity.Customer;
import af.test.service.CustomerEJB;


@WebServlet("/incluir")
public class IncluirServlet extends HttpServlet {
	
	
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
		
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstname(firstname);
		customer.setLastname(lastname);

		
		Child child1 = new Child(1,"Child1",lastname);
		Child child2 = new Child(2,"Child2",lastname);

		customer.getChildren().add(child1);
		customer.getChildren().add(child2);
		
		ejb.incluir(customer);
		
		
		
		
		
		writer.append("<html> Customer created!");
		writer.append("id:"+id+"<br/>");
		writer.append("firstname:"+firstname+"<br/>");
		writer.append("lastname:"+lastname+"<br/>");
		writer.append("</html>");
		
	}
	

}
