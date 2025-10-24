package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

/**
 * Interface for service layer
 */
public interface EmployeeService {

    /**
     * Provides a list of all employees
     * @return One or more Employees.
     */
    List<Employee> getAllEmployees();
    /**
     * Returns employee data for employee with specified uuid
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    Employee getEmployeeByUuid(UUID uuid);
    /**
     * Creates a new employee
     * @param employee newly created object of class Employee
     * @return Newly created Employee
     */
    Employee createEmployee(Employee e);
}
