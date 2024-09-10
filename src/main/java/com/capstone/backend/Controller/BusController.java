package com.capstone.backend.Controller;

import com.capstone.backend.Dto.BusResponseDto;
import com.capstone.backend.Entity.Bus;
import com.capstone.backend.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/search")
    public ResponseEntity<List<BusResponseDto>> getBuses(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String availableDate) {
        List<BusResponseDto> buses = busService.getBuses(source, destination, availableDate);
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/booking")
    public ResponseEntity<BusResponseDto> getBusByID(
            @RequestParam String busId,
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String date){
        Integer id = Integer.parseInt(busId);
        BusResponseDto bus = busService.getBusById(id,source, destination,date);
        return ResponseEntity.ok(bus);
    }
}
