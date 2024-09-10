package com.capstone.backend.Repository;

import com.capstone.backend.Entity.Bookings;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends MongoRepository<Bookings, ObjectId> {

    Bookings findByBusIdAndDate(Integer BusId,String Date);
}
