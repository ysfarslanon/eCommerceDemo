package gameShopDemo.Business.Concrete;

import gameShopDemo.Business.Abstract.GamerCheckService;
import gameShopDemo.Business.Abstract.GamerService;
import gameShopDemo.Entities.Gamer;

public class GamerManager implements GamerService{
	private GamerCheckService gamerCheckService;
	

	public GamerManager(GamerCheckService gamerCheckService) {		
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void register(Gamer gamer) {
		String fullName=gamer.getFirstName()+" "+gamer.getLastName();
		if(gamerCheckService.checkRealPerson(gamer)) {
			System.out.println("Kay�t olundu: " + gamer.getFirstName()+" "+gamer.getLastName());
		}else {
			System.out.println("Ger�ek ki�i hatas�. "+fullName);
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		String fullName=gamer.getFirstName()+" "+gamer.getLastName();
		System.out.println("Oyuncu g�ncellendi. "+ fullName);
	}

	@Override
	public void delete(Gamer gamer) {
		String fullName=gamer.getFirstName()+" "+gamer.getLastName();
		System.out.println("Oyuncu silindi. "+ fullName);
		
	}

}
