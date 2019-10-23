package edu.mum.cs.cs452.safeairlines.repository;

import edu.mum.cs.cs452.safeairlines.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
   List<Flight> findAllByFlightNumberContainingOrPlaneNumberContainingOrDepaturePlaceContainingOrArrivalPlaceContains(String flightNumber, String planeNumber,
                                                                                                                   String depaturPlace,
                                                                                                                       String arrivalPlace);
   List<Flight> findAllByFlightNumberContainingAndPlaneNumberContaining(String chain1,String chain2);
}
