package com.capstone.backend.Controller;

import com.capstone.backend.Dto.TicketResponse;
import com.capstone.backend.Service.Impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;
    @GetMapping("/view")
    public TicketResponse getTicket(@RequestParam String passengerId,
                                    @RequestParam String bookingId){
        return ticketService.getTicket(passengerId,Integer.parseInt(bookingId));
    }
}
