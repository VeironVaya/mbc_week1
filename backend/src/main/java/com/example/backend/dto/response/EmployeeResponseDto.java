package com.example.backend.dto.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeResponseDto implements Serializable {

    private Long idEmployee;
    private String name;
    private Long age;
    private String position;
    private String positionJob;
    private String report;
}
