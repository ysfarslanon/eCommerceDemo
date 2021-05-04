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
			System.out.println("Kayýt olundu: " + gamer.getFirstName()+" "+gamer.getLastName());
		}else {
			System.out.println("Gerçek kiþi hatasý. "+fullName);
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		String fullName=gamer.getFirstName()+" "+gamer.getLastName();
		System.out.println("Oyuncu güncellendi. "+ fullName);
	}

	@Override
	public void delete(Gamer gamer) {
		String fullName=gamer.getFirstName()+" "+gamer.getLastName();
		System.out.println("Oyuncu silindi. "+ fullName);
		
	}

}
