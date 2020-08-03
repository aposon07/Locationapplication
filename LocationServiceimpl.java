package com.Ben.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ben.location.entities.Location;
import com.Ben.location.repos.LocationRepository;

@Service
public class LocationServiceimpl implements Locationservice {
	
	@Autowired
	private LocationRepository repository;

	@Override
	public Location saveLocation(Location Location) {
		return repository.save(Location);
	}

	@Override
	public Location updateLocation(Location Location) {
		return repository.save(Location);
	}

	@Override
	public void deleteLocation(Location Location) {
		repository.delete(Location);

	}

	@Override
	public Location getLocationById(int id) {
				return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return repository.findAll();
	}

	public LocationRepository getRepository() {
		return repository;
	}

	public void setRepository(LocationRepository repository) {
		this.repository = repository;
	}

}
