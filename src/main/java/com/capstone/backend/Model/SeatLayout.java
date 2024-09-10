package com.capstone.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatLayout {
    private Layout lower;
    private Layout upper;
    private List<List<Integer>> first;
    private List<List<Integer>> second;
}
