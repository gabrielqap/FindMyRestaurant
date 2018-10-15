package imd0412.findmyrestaurant.service;

import java.util.List;

import imd0412.findmyrestaurant.domain.GeoCoordinate;
import imd0412.findmyrestaurant.domain.Restaurant;
import imd0412.findmyrestaurant.domain.Review;

public interface IRestaurantService
{
	public List<Restaurant> findNearRestaurants(GeoCoordinate coordinates);

	public List<Review> getReviews(String restaurantName);
}
