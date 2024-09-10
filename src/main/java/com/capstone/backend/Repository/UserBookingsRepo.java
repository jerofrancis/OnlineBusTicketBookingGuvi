package com.capstone.backend.Repository;

import com.capstone.backend.Entity.UserBookings;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookingsRepo extends MongoRepository<UserBookings, ObjectId> {

    List<UserBookings> findAllByEmail(String email);

    UserBookings findByBookingId(Integer bookingId);

    UserBookings findByEmailAndBookingId(String email,Integer bookingId);



}
