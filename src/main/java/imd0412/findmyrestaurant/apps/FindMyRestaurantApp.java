package imd0412.findmyrestaurant.apps;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import imd0412.findmyrestaurant.api.FindMyRestaurantAPI;
import imd0412.findmyrestaurant.domain.Restaurant;
import imd0412.findmyrestaurant.factory.ServiceFactory;
import imd0412.findmyrestaurant.service.IMapService;
import imd0412.findmyrestaurant.service.IRestaurantService;

public class FindMyRestaurantApp
{
	public static void main(String[] args)
	{
		IMapService mapService = ServiceFactory.createMapService();
		IRestaurantService restaurantService = ServiceFactory.createRestaurantService();

		FindMyRestaurantAPI recommender = new FindMyRestaurantAPI(mapService, restaurantService);

		try (Scanner scanner = new Scanner(in))
		{
			out.println("Digite a especialidade dos restaurantes que você quer buscar (ex.: Frutos do Mar, Regional):");
			String speciality = scanner.nextLine();

			out.println("Digite o endereço próximo de onde você quer encontrar restaurantes: ");
			String address = scanner.nextLine();

			List<Restaurant> nearRestaurantBySpeciality = recommender.findNearRestaurantsBySpeciality(address,
					speciality);

			if (nearRestaurantBySpeciality.isEmpty())
			{
				out.printf("Nenhum restaurante especializado em '%s' próximo ao endereço '%s'.\n", speciality, address);
			}
			else
			{

				out.printf("These are the restaurants specialized in '%s' close to you:\n", speciality);
				for (Restaurant r : nearRestaurantBySpeciality)
				{
					out.println(r);
				}
			}
		}
		catch (Exception e)
		{
			out.println("An error occurred while trying to get your recommendations. Sorry about that!");
			out.println("We could not give your recommendations because: " + e.getMessage());
		}
	}
}
