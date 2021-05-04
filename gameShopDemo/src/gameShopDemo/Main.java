package gameShopDemo;

import java.time.LocalDate;
import java.util.Date;
import gameShopDemo.Business.Abstract.*;
import gameShopDemo.Business.Concrete.*;
import gameShopDemo.Entities.*;

public class Main {

	public static void main(String[] args) {
		
		GamerCheckService gamerCheckService= new GamerCheckWithMernis();
		GameService gameManager= new GameManager();
		GamerService gamerManager= new GamerManager(gamerCheckService);
		CampaignService campainManager = new CampaignManager();
		
		Game gameGtaV=new Game(1, "Gta V", 500);
		Game gameFifa21 = new Game(2,"FIFA 21",600);
		Game gameFortnite =new Game(3,"Fortnite",200);
		Gamer gamerYusuf = new Gamer(1,"33736646884","Yusuf","Arslan",LocalDate.of(1997,2,3));
		Gamer gamerFake = new Gamer(2,"01234567890","Fake","Fake",LocalDate.of(1997,2,3));
		Campaign campaign10 = new Campaign(1,"%10 indirim.",10);
		Campaign campaign1550 = new Campaign(2,"%15.50 indirim.",15.50);
		Campaign campaign100 = new Campaign(3,"%100 indirim.",100);
	
		System.out.println("------Gerçek kiþi kontrolu.------");		
		System.out.println(gamerCheckService.checkRealPerson(gamerYusuf));
		System.out.println(gamerCheckService.checkRealPerson(gamerFake));
		
		System.out.println("------Oyun  kontrolu.------");
		gameManager.add(gameGtaV);
		gameManager.update(gameGtaV);
		gameManager.delete(gameGtaV);
		gameManager.sale(gameFortnite, gamerYusuf);
		gameManager.sale(gameFortnite, gamerFake, campaign10);
		gameManager.sale(gameFifa21, gamerFake, campaign1550);
		gameManager.sale(gameGtaV, gamerFake, campaign100);
		
		System.out.println("------Oyuncu kontrolu.------");
		gamerManager.register(gamerFake);
		gamerManager.register(gamerYusuf);
		gamerManager.delete(gamerYusuf);
		gamerManager.update(gamerYusuf);
		
		System.out.println("------Kampanya kontrolu.------");
		campainManager.add(campaign100);
		campainManager.delete(campaign1550);
		campainManager.update(campaign10);	
		
		
	}

}
