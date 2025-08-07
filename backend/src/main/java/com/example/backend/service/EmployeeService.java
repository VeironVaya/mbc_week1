package com.example.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.backend.dto.request.EmployeeRequestDto;
import com.example.backend.dto.response.EmployeeResponseDto;
import com.example.backend.dto.response.EmployeesResponseDto;
import com.example.backend.dto.response.SimpleResponseDto;
import com.example.backend.entity.Employee;
import com.example.backend.mapper.EmployeeMapper;
import com.example.backend.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @CacheEvict(value = "employees", key = "'allEmployees'")
    public SimpleResponseDto postReport(EmployeeRequestDto reqDto) {
        Employee employee = new Employee();

        SimpleResponseDto response = new SimpleResponseDto();

        employee.setName(reqDto.getName());
        employee.setAge(reqDto.getAge());
        employee.setPosition(reqDto.getPosition());
        employee.setPositionJob(reqDto.getPositionJob());
        employee.setReport(reqDto.getReport());

        response.setMessage("successfully input data");
        response.setStatus("true");

        employeeRepository.save(employee);

        return response;

    }

    @Cacheable(value = "employees", key = "'allEmployees'")
    public EmployeesResponseDto getAllReport() {
        System.out.println("[CACHE MISS] Fetching employees from database...");
        List<EmployeeResponseDto> dtos = employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employeeToDto)
                .collect(Collectors.toList());

        EmployeesResponseDto response = new EmployeesResponseDto();
        response.setEmployees(dtos);
        response.setStatus("true");
        response.setMessage("retrieve successfully");

        return response;
    }

}
