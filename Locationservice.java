package com.Ben.location.service;

import java.util.List;

import com.Ben.location.entities.Location;

public interface Locationservice {

	Location saveLocation(Location Location);
	Location updateLocation(Location Location);
	void deleteLocation(Location Location);
	Location getLocationById(int id);
	List<Location> getAllLocations();
}
