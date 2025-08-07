package com.example.backend.dto.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeRequestDto implements Serializable {
    private String name;
    private Long age;
    private String position;
    private String positionJob;
    private String report;
}
