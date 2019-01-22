/**
 * 
 */
package com.crossover.techtrial.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.repositories.RideRepository;

/**
 * @author crossover
 *
 */
@Service
public class RideServiceImpl implements RideService {

	@Autowired
	RideRepository rideRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;	

	private final String NATIVE_QRY = 
			"SELECT DRIVER_ID, NAME, EMAIL, SUM(TIME_TO_SEC(TIMEDIFF(END_TIME,START_TIME))) totalRideDurationInSeconds, " + 
		    "TIME_TO_SEC(MAX(TIMEDIFF(END_TIME,START_TIME))) maxRideDurationInSecods, " +
			"AVG(DISTANCE) averageDistance " + 
		    "FROM RIDE " +
			"JOIN PERSON ON RIDE.DRIVER_ID = PERSON.ID "+
			"WHERE " + 
		    "DATE_FORMAT(START_TIME, '%Y-%m-%d %H:%i') >= :sdate " + 
			"AND DATE_FORMAT(END_TIME, '%Y-%m-%d %H:%i') <= :edate " +
		    "GROUP BY  DRIVER_ID "+
			"ORDER BY 5 DESC "
		    ; 
	
	public Ride save(Ride ride) {
		return rideRepository.save(ride);
	}

	public Ride findById(Long rideId) {
		Optional<Ride> optionalRide = rideRepository.findById(rideId);
		if (optionalRide.isPresent()) {
			return optionalRide.get();
		} else
			return null;
	}

	@Override
	public List<TopDriverDTO> getTopDrivers(Long count, LocalDateTime startTime, LocalDateTime endTime) {		;
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(NATIVE_QRY + String.valueOf(" LIMIT "+ count) )
				  .setParameter("sdate", startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString())
				  .setParameter("edate", endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString());
		List<Object[]> topDriversObject = q.getResultList();
		List<TopDriverDTO> topDrivers = new ArrayList<TopDriverDTO>();
		for(Object[] ob : topDriversObject){
			TopDriverDTO driver = new TopDriverDTO(ob[1].toString(), ob[2].toString(), ((BigDecimal)ob[3]).longValue() ,
					((BigDecimal)ob[4]).longValue(), ((BigDecimal)ob[5]).doubleValue() );
			topDrivers.add(driver);			
		}
		return topDrivers;
	}

}
