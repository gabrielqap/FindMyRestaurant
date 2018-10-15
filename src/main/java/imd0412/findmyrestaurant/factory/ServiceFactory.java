package imd0412.findmyrestaurant.factory;

import imd0412.findmyrestaurant.service.IMapService;
import imd0412.findmyrestaurant.service.IRestaurantService;

public class ServiceFactory
{
	public static IMapService createMapService()
	{
		return MapServiceFactory.createService();
	}

	public static IRestaurantService createRestaurantService()
	{
		return RestaurantServiceFactory.createService();
	}
}
