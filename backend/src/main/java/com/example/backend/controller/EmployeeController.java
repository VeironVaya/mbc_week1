package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.request.EmployeeRequestDto;
import com.example.backend.dto.response.EmployeesResponseDto;
import com.example.backend.dto.response.SimpleResponseDto;
import com.example.backend.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private final EmployeeService empService;

    @PostMapping
    public SimpleResponseDto postEmployeeReport(@RequestBody EmployeeRequestDto reqDto) {
        return empService.postReport(reqDto);
    }

    @GetMapping
    public EmployeesResponseDto getEmployeeReport() {
        return empService.getAllReport();
    }
}
