package com.capstone.backend.Service.Impl;

import com.capstone.backend.Dto.TicketResponse;
import com.capstone.backend.Entity.UserBookings;
import com.capstone.backend.Repository.UserBookingsRepo;
import com.capstone.backend.Service.TicketService;
import com.capstone.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private UserBookingsRepo userBookingsRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TicketResponse getTicket(String passengerId, Integer bookingId) {
        UserBookings userBookings = userBookingsRepo.findByEmailAndBookingId(passengerId, bookingId);

        String userName = userRepository.findNameByEmail(passengerId);

        TicketResponse ticket = new TicketResponse();
        ticket.setUserName(userName);
        ticket.setUserBookings(userBookings);
        return ticket;
    }
}
