package proje;

import java.rmi.RemoteException;
import java.time.ZoneId;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		
		try {
		return client.TCKimlikNoDogrula(
				Long.parseLong(customer.getNationalityId()),
				customer.getFirstName().toUpperCase(),
				customer.getLastName().toUpperCase(), 
				customer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear());
	}
		catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
}
		return result;
		
	}
}

