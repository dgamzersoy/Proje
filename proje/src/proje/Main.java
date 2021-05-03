package proje;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) throws RemoteException {
	
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Dilek Gamze" );
		customer.setLastName("Ersoy");
		customer.setNationalityId("16513133890");
		customer.setDateOfBirth(new GregorianCalendar(1994, 8 , 21).getTime());
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
	    customerManager.Save(customer);


	
	}

}
