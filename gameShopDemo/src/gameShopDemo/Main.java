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
		Game gameNFSHeat =new Game(3,"NFS Heat",200);
		
		Gamer gamerYusuf = new Gamer(1,"TCNO","Yusuf","Arslan",LocalDate.of(1997,2,3));
		Gamer gamerFake = new Gamer(2,"01234567890","Sahte","Kiþi",LocalDate.of(1997,2,3));
		
		Campaign campaign10 = new Campaign(1,"%10 indirim.",10);
		Campaign campaign1550 = new Campaign(2,"%15.50 indirim.",15.50);
		Campaign campaign100 = new Campaign(3,"%100 indirim.",100);
	
		System.out.println("------Gerçek kiþi kontrolu.------");		
		System.out.println(gamerCheckService.checkRealPerson(gamerYusuf));
		System.out.println(gamerCheckService.checkRealPerson(gamerFake));
		
		System.out.println("------Oyun kontrolu.------");
		gameManager.add(gameGtaV);
		gameManager.update(gameFifa21);
		gameManager.delete(gameNFSHeat);
		
		System.out.println("------Oyun satýþ (kampanyalý - kampanyasýz) kontrolu.------");
		gameManager.sale(gameNFSHeat, gamerYusuf);
		gameManager.sale(gameNFSHeat, gamerYusuf, campaign10);
		gameManager.sale(gameFifa21, gamerYusuf);
		gameManager.sale(gameFifa21, gamerYusuf, campaign1550);
		gameManager.sale(gameGtaV, gamerYusuf);
		gameManager.sale(gameGtaV, gamerYusuf, campaign100);
		
		System.out.println("------Oyuncu kontrolu.------");
		gamerManager.register(gamerYusuf);
		gamerManager.register(gamerFake);		
		gamerManager.delete(gamerYusuf);
		gamerManager.update(gamerYusuf);
		
		System.out.println("------Kampanya kontrolu.------");
		campainManager.add(campaign100);
		campainManager.delete(campaign1550);
		campainManager.update(campaign10);	
		
		
	}

}
