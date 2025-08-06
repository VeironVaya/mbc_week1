package com.example.backend.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeResponseDto {

    private Long idEmployee;
    private String name;
    private Long age;
    private String position;
    private String positionJob;
    private String report;
}
