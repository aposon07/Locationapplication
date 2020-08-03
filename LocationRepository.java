package com.Ben.location.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Ben.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	

}
