package com.capstone.backend.Service.Impl;

import com.capstone.backend.Dto.RequestBooking;
import com.capstone.backend.Entity.Bookings;
import com.capstone.backend.Entity.Bus;
import com.capstone.backend.Entity.UserBookings;
import com.capstone.backend.Model.ReservationResponse;
import com.capstone.backend.Repository.BookingRepo;
import com.capstone.backend.Repository.BusRepository;
import com.capstone.backend.Repository.UserBookingsRepo;
import com.capstone.backend.Service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserBookingsRepo userBookingsRepo;
    @Override
    public ReservationResponse reserveBooking(String userEmail, RequestBooking request) {
        Bookings bookings = bookingRepo.findByBusIdAndDate(request.getBusId(), request.getDate());

        Integer BookingId = null;
        ReservationResponse response = null;

        if (bookings != null) {
            bookings.setBookedSeats(request.getBookedSeats());
            bookingRepo.save(bookings);
        } else {
            SecureRandom random = new SecureRandom();

            Bookings newBooking = new Bookings();
            BookingId = 100000 + random.nextInt(900000);
            newBooking.setBusId(request.getBusId());
            newBooking.setBookedSeats(request.getBookedSeats());
            newBooking.setDate(request.getDate());
            newBooking.setBookingId(BookingId);
            bookingRepo.save(newBooking);
        }
        Bookings existingBooking = bookingRepo.findByBusIdAndDate(request.getBusId(), request.getDate());
        Bus bus = busRepository.findByIdAndSourceAndDestination(request.getBusId(), request.getSource(), request.getDestination());

        UserBookings existingUserBooking = userBookingsRepo.findByBookingId(existingBooking.getBookingId());
        if (existingUserBooking != null) {
            existingUserBooking.setReservedSeats(request.getBookedSeats());
            existingUserBooking.setTotalPrice(existingUserBooking.getTotalPrice() + request.getBookedSeats().size() * bus.getPrice());

            userBookingsRepo.save(existingUserBooking);
            response = new ReservationResponse();

            response.setDate(request.getDate());
            response.setBookingID(existingUserBooking.getBookingId());
            response.setSubtotal(request.getBookedSeats().size() * bus.getPrice());
            response.setTotal(request.getBookedSeats().size() * bus.getPrice());
        } else {
        UserBookings userBookings = new UserBookings();
        userBookings.setEmail(userEmail);
        modelMapper.map(bus, userBookings);
        userBookings.setTotalPrice(bus.getPrice() * request.getBookedSeats().size());
        modelMapper.map(existingBooking, userBookings);

        userBookings.setReservedSeats(request.getBookedSeats());
        userBookings.setTotalPrice(request.getBookedSeats().size() * bus.getPrice());

        userBookingsRepo.save(userBookings);

            response = new ReservationResponse();
            response.setDate(request.getDate());
            response.setBookingID(userBookings.getBookingId());
            response.setSubtotal(request.getBookedSeats().size() * bus.getPrice());
            response.setTotal(request.getBookedSeats().size() * bus.getPrice());
        }
        return response;
    }

    @Override
    public Integer getTotalPrice(RequestBooking request) {
        Bus bus = busRepository.findByIdAndSourceAndDestination(request.getBusId(), request.getSource(), request.getDestination());
        return bus.getPrice() * request.getBookedSeats().size();
    }
}
