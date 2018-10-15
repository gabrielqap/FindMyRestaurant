package imd0412.findmyrestaurant.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import imd0412.findmyrestaurant.domain.GeoCoordinate;
import imd0412.findmyrestaurant.domain.Restaurant;
import imd0412.findmyrestaurant.domain.Review;
import imd0412.findmyrestaurant.service.IMapService;
import imd0412.findmyrestaurant.service.IRestaurantService;

public class FindMyRestaurantAPITest
{

	@Test
	public final void testNearRestaurants_WithStubs()
	{
		IMapService mapService = new IMapService()
		{

			@Override
			public GeoCoordinate convertToGeographicCoordinates(String address)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
		IRestaurantService restaurantService = new IRestaurantService()
		{

			@Override
			public List<Review> getReviews(String restaurantName)
			{
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Restaurant> findNearRestaurants(GeoCoordinate coordinates)
			{
				// TODO Auto-generated method stub
				return null;
			}
		};

		FindMyRestaurantAPI api = new FindMyRestaurantAPI(mapService, restaurantService);

		// INPUTS
		String speciality = "Regional";
		String address = "Av. Salgado Filho, 1900.";

		List<Restaurant> nearRestaurants = api.findNearRestaurantsBySpeciality(address, speciality);

		Assert.assertFalse(nearRestaurants.isEmpty());
	}

}
