package com.chyld.repositories;

import com.chyld.models.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VehicleRepository  extends PagingAndSortingRepository<Vehicle, Integer> {
}
