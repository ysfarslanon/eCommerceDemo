package gameShopDemo.Business.Abstract;

import gameShopDemo.Entities.Game;
import gameShopDemo.Entities.Gamer;
import gameShopDemo.Entities.Campaign;

public interface GameService {
	void sale(Game game,Gamer gamer);
	void sale(Game game,Gamer gamer,Campaign campain);
	void add(Game game);
	void delete(Game game);
	void update(Game game);
}
