package imd0412.findmyrestaurant.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import imd0412.findmyrestaurant.domain.GeoCoordinate;
import imd0412.findmyrestaurant.domain.Restaurant;
import imd0412.findmyrestaurant.domain.Review;
import imd0412.findmyrestaurant.service.IMapService;
import imd0412.findmyrestaurant.service.IRestaurantService;
import imd0412.findmyrestaurant.util.Util;

public class FindMyRestaurantAPI
{
	private final IMapService mapService;
	private final IRestaurantService restaurantService;

	public FindMyRestaurantAPI(IMapService mapService, IRestaurantService restaurantService)
	{
		this.mapService = mapService;
		this.restaurantService = restaurantService;
	}

	/**
	 * Método que retorna uma lista de restaurantes, de uma determinada
	 * especialidaed, próximos a um endereço.
	 * 
	 * @param address
	 *            endereço próximo a onde serão buscados os restaurantes.
	 * @param speciality
	 *            especialidade dos restaurantes a serem buscados.
	 * @return
	 */
	public List<Restaurant> findNearRestaurantsBySpeciality(String address, String speciality)
	{
		GeoCoordinate coord = mapService.convertToGeographicCoordinates(address);

		List<Restaurant> nearRestaurants = restaurantService.findNearRestaurants(coord);

		Stream<Restaurant> filtered = nearRestaurants.stream().filter(t -> t.getSpeciality().equals(speciality));

		return filtered.collect(Collectors.toList());
	}

	/**
	 * Método que retorna um mapa que associa palavras a sua contagem em todos
	 * os comentários feitos para um determinado restaurante.
	 * 
	 * @param restaurantName
	 *            nome do restaurante a ser analisado
	 * @return
	 */
	public Map<String, Integer> getFrequentWordsInReviews(String restaurantName)
	{
		List<Review> reviews = restaurantService.getReviews(restaurantName);

		List<String> comments = new ArrayList<>();
		for (Review review : reviews)
		{
			String comment = review.getComment();
			comments.add(comment);
		}

		Map<String, Integer> result = Util.countWords(comments);

		return result;
	}
}
