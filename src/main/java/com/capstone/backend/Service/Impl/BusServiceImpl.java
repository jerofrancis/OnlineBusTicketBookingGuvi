package com.capstone.backend.Service.Impl;

import com.capstone.backend.Dto.BusResponseDto;
import com.capstone.backend.Entity.Bookings;
import com.capstone.backend.Entity.Bus;
import com.capstone.backend.Repository.BookingRepo;
import com.capstone.backend.Repository.BusRepository;
import com.capstone.backend.Service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepo bookingRepo;
    @Override
    public List<BusResponseDto> getBuses(String source, String destination, String availableDate) {
        List<Bus> BusList =  busRepository.findBySourceAndDestination(source, destination);
        List<BusResponseDto> busResponseDtoList = new ArrayList<>();
        for (Bus bus: BusList) {
            BusResponseDto busResponseDto = new BusResponseDto();
            modelMapper.map(bus,busResponseDto);
            Bookings bookings = bookingRepo.findByBusIdAndDate(bus.getId(),availableDate);
            if(bookings != null){
                busResponseDto.setBookings(bookings);
            }else{
                Bookings emptyBookings = new Bookings();
                emptyBookings.setBusId(bus.getId());
                emptyBookings.setBookedSeats(new ArrayList<>());
                emptyBookings.setDate(availableDate);
                busResponseDto.setBookings(emptyBookings);
            }
            busResponseDtoList.add(busResponseDto);
        }
        return busResponseDtoList;
    }

    @Override
    public BusResponseDto getBusById(Integer busId, String source, String destination, String date) {
        Bus bus = busRepository.findByIdAndSourceAndDestination(busId,source,destination);
        Bookings bookings = bookingRepo.findByBusIdAndDate(bus.getId(),date);

        BusResponseDto busResponse = new BusResponseDto();
        modelMapper.map(bus,busResponse);

        if(bookings != null){
            busResponse.setBookings(bookings);
        }else{
            Bookings emptyBookings = new Bookings();
            emptyBookings.setBusId(bus.getId());
            emptyBookings.setBookedSeats(new ArrayList<>());
            emptyBookings.setDate(date);
            busResponse.setBookings(emptyBookings);
        }

        return busResponse;

    }
}
