package com.example.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeRequestDto {
    private String name;
    private Long age;
    private String position;
    private String positionJob;
    private String report;
}
