package com.example.backend.mapper;

import org.springframework.stereotype.Component;

import com.example.backend.dto.response.EmployeeResponseDto;
import com.example.backend.entity.Employee;

@Component
public class EmployeeMapper {
    public EmployeeResponseDto employeeToDto(Employee e) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setIdEmployee(e.getIdEmployee());
        dto.setName(e.getName());
        dto.setAge(e.getAge());
        dto.setPosition(e.getPosition());
        dto.setPositionJob(e.getPositionJob());
        dto.setReport(e.getReport());
        return dto;
    }
}
