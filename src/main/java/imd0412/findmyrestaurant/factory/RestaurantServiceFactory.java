package imd0412.findmyrestaurant.factory;

import java.util.LinkedList;
import java.util.List;

import imd0412.findmyrestaurant.domain.GeoCoordinate;
import imd0412.findmyrestaurant.domain.Restaurant;
import imd0412.findmyrestaurant.domain.Review;
import imd0412.findmyrestaurant.service.IRestaurantService;

public class RestaurantServiceFactory
{
	public static IRestaurantService createService()
	{
		IRestaurantService B = new IRestaurantService() {
			
			@Override
			public List<Review> getReviews(String restaurantName) {
				List<Review> Reviews = new LinkedList<Review>();
				Review It = new Review();
				
			}
			
			@Override
			public List<Restaurant> findNearRestaurants(GeoCoordinate coordinates) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return B;
	}

}
