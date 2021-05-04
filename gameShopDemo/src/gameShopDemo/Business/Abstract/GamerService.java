package gameShopDemo.Business.Abstract;

import gameShopDemo.Entities.Gamer;

public interface GamerService {
	void register(Gamer gamer);
	void update(Gamer gamer);
	void delete(Gamer gamer);
}
