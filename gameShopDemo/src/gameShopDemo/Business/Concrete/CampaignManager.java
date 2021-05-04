package gameShopDemo.Business.Concrete;

import gameShopDemo.Business.Abstract.CampaignService;

import gameShopDemo.Entities.Campaign;

public class CampaignManager implements CampaignService{

	@Override
	public void add(Campaign campaign) {
		System.out.println(campaign.getName()+" kampanyasý oluþturuldu.");
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println(campaign.getName()+" kampanyasý silindi.");
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println(campaign.getName()+" kampanyasý düzenlendi.");
		
	}

	
	

}
