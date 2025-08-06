package com.example.backend.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeesResponseDto {
    private String status;
    private String message;
    private List<EmployeeResponseDto> employees;
}
