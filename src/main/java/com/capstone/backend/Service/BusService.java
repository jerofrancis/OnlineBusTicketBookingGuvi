package com.capstone.backend.Service;

import com.capstone.backend.Dto.BusResponseDto;
import com.capstone.backend.Entity.Bus;

import java.util.List;

public interface BusService {

    public List<BusResponseDto> getBuses(String source, String destination, String availableDate);

    BusResponseDto getBusById(Integer busId, String source, String destination, String date);
}
