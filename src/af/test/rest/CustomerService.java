package af.test.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import af.test.entity.Customer;
import af.test.service.CustomerEJB;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerService {

	@Inject
	private CustomerEJB ejb;
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") Integer id) {

		System.out.println("Lendo id "+id);
		Customer customer = ejb.ler(id);
		
		return Response.status(200).entity(customer).build();

	}

}