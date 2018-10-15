package imd0412.findmyrestaurant.service;

import imd0412.findmyrestaurant.domain.GeoCoordinate;

public interface IMapService
{
	GeoCoordinate convertToGeographicCoordinates(String address);
}
