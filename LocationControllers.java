package com.Ben.location.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ben.location.service.Locationservice;


@Controller
public class LocationControllers {
	
	
	@Autowired
	Locationservice service;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		Location LocationSaved = service.saveLocation(location);
		String msg = "Location saved with id: " + LocationSaved.getId();
		modelMap.addAttribute("msg" , msg);
		return "createLoation";
	}
	
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap) {
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations" , locations);
		return"displayLocations";
	}
	
	
	@RequestMapping("/deleteLocations")
	public String deleteLocation(@RequestParam("id") int id , ModelMap modelmap) {
	//	Location location = service.getLocationById(id); or the next 2 codes below
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations" , locations);
		return"displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id , ModelMap modelmap) {
		Location locations = service.getLocationById(id);
		modelmap.addAttribute("locations" , locations);
		return"updateLocation";
	}
	
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations" , location);
		return "displayLocation";
	}
	
	
}
