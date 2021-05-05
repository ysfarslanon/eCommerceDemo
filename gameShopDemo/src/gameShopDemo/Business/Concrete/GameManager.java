package gameShopDemo.Business.Concrete;

import gameShopDemo.Business.Abstract.*;
import gameShopDemo.Entities.Gamer;
import gameShopDemo.Entities.Campaign;
import gameShopDemo.Entities.Game;

public class GameManager implements GameService{

	
	@Override
	public void sale(Game game, Gamer gamer) {
		String gamerFullName=gamer.getFirstName()+" "+gamer.getLastName();
		System.out.println(
				game.getName()+" oyunu "+game.getPrice()+" TL olarak "+gamerFullName+" oyuncusuna satýldý.");
		
	}

	@Override
	public void sale(Game game, Gamer gamer, Campaign campain) {
		String gamerFullName=gamer.getFirstName()+" "+gamer.getLastName();
		double gameCampainPrice=game.getPrice()-(game.getPrice()*campain.getDiscountPercent()/100);
		System.out.println(
				game.getName()+" oyunu %"+campain.getDiscountPercent()+" indirimle "+ gameCampainPrice+" TL olarak "+gamerFullName+" oyuncusuna satýldý.");
		
		
	}

	@Override
	public void add(Game game) {
		System.out.println(game.getName()+" oyunu eklendi");
		
	}

	@Override
	public void delete(Game game) {
		System.out.println(game.getName()+" oyunu silindi");
		
	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName()+" oyunu düzenlendi");
		
	}

	

}
