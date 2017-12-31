package af.test.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import af.test.entity.Child;
import af.test.entity.Customer;

@Stateless
public class CustomerEJB {

    @PersistenceContext(unitName="AFJEE")    
    private EntityManager em;
	
	public void incluir(Customer customer) {
		System.out.println(customer.getFirstname()+" "+customer.getLastname());
		em.persist(customer);
	}
	
	
	public Customer ler(Integer id) {
		Customer customer = em.find(Customer.class,id);
		System.out.println("Leitura : " + customer);
		return customer;
	}

	public Customer processar(Customer customer) {
		System.out.println(customer.getFirstname()+" "+customer.getLastname());
		
		customer = em.merge(customer);
		
		
		String forcedName = "Force_"+System.currentTimeMillis();
		customer.setLastname(forcedName);
		for(Child child: customer.getChildren()) {
			child.setLastname(forcedName);
		}
		
		return customer;
	}
	
	
}
