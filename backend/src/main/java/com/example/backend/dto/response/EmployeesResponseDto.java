package com.example.backend.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeesResponseDto implements Serializable {
    private String status;
    private String message;
    private List<EmployeeResponseDto> employees;
}
