package gameShopDemo.Business.Concrete;

import gameShopDemo.Business.Abstract.GamerCheckService;
import gameShopDemo.Entities.Gamer;
import tr.gov.nvi.tckimlik.WS.*;

public class GamerCheckWithMernis implements GamerCheckService{

	@Override
	public boolean checkRealPerson(Gamer gamer) {
		KPSPublicSoap mernis=new KPSPublicSoapProxy();
		boolean result =false;
		try {
			result=mernis.TCKimlikNoDogrula(
					Long.parseLong(gamer.getNationalityId()),
					gamer.getFirstName().toUpperCase(),
					gamer.getLastName().toUpperCase(),
					gamer.getBirthofDate().getYear());
		} catch (Exception e) {
			System.out.println("HATAAAA:"+e.getMessage());
		}
		return result;
	}

}
