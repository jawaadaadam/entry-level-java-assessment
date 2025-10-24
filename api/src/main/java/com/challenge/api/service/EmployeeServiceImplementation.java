package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImplementation;
import java.time.Instant;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Concrete implementation of EmployeeService.
 * Holds mock employee data in-memory for the REST API.
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final Map<UUID, Employee> mockData = new HashMap<>();

    public EmployeeServiceImplementation() {
        Employee e1 = new EmployeeImplementation(UUID.randomUUID(), "John", "Doe", "Analyst");
        Employee e2 = new EmployeeImplementation(UUID.randomUUID(), "Jake", "Doc", "Secretary");
        Employee e3 = new EmployeeImplementation(UUID.randomUUID(), "Jeff", "Dat", "CEO");

        mockData.put(e1.getUuid(), e1);
        mockData.put(e2.getUuid(), e2);
        mockData.put(e3.getUuid(), e3);
    }

    /**
     * Provides a list of all employees
     * @return One or more Employees.
     */
    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(mockData.values());
    }
    /**
     * Returns employee data for employee with specified uuid
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        Employee e = mockData.get(uuid);
        if (e == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        } else return e;
    }
    /**
     * Creates a new employee
     * @param employee newly created object of class Employee
     * @return Newly created Employee
     */
    @Override
    public Employee createEmployee(Employee e) {
        if (e.getUuid() == null) {
            e.setUuid(UUID.randomUUID());
        }
        if (e.getContractHireDate() == null) {
            e.setContractHireDate(Instant.now());
        }
        mockData.put(e.getUuid(), e);
        return e;
    }
}
