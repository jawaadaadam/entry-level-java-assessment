package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

/**
 * Implementation of the Employee interface.
 * To be used by REST API
 */
public class EmployeeImplementation implements Employee {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant hireDate;
    private Instant terminationDate;

    /**
     * Class constructor to be used by REST API
     */
    public EmployeeImplementation () {}

    /**
     * Class constructor to generate default data 
     * @param uuid required non-null
     * @param fname first name
     * @param lname last name
     * @param jobTitle job title 
     */
    public EmployeeImplementation (UUID uuid, String fname, String lname, String jobTitle) {

        this.uuid = uuid;
        this.firstName = fname;
        this.lastName = lname;
        this.jobTitle = jobTitle;
        this.hireDate = Instant.now();
    }

    /**
     * Get object uuid
     */
    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Set by either the Service or Data layer.
     * @param uuid required non-null
     */
    @Override
    public void setUuid(UUID uuid) {
        if (uuid == null)
            throw new IllegalArgumentException("Uuid must not be null.");
        else
            this.uuid = uuid;
    }

    /**
     * Get object first name 
     */
    @Override
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set by either the Service or Data layer.
     * @param name first name 
     */
    @Override
    public void setFirstName(String name) {
        this.firstName = name;
    }

    /**
     * Get object last name
     */
    @Override
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set by either the Service or Data layer.
     * @param name last name
     */
    @Override
    public void setLastName(String name) {
        this.lastName = name;
    }

    /**
     * Get object full name 
     */
    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * Set by either the Service or Data layer.
     * @param name full name 
     */
    @Override
    public void setFullName(String name) {
        if(name == null || name.isBlank()){
            this.firstName = "";
            this.lastName = "";
            return;
        }
        String[] nameParts = name.trim().split(" ", 2);
        this.firstName = nameParts[0];
        this.lastName = nameParts.length > 1 ? nameParts[1] : "";
    }

    /**
     * Get object salary
     */
    @Override
    public Integer getSalary() {
        return this.salary;
    }

    /**
     * Set by either the Service or Data layer.
     * @param salary salary
     */
    @Override
    public void setSalary(Integer salary){
        this.salary = salary; 
    }

    /**
     * Get object age
     */
    @Override
    public Integer getAge() {
        return this.age;
    }

    /**
     * Set by either the Service or Data layer.
     * @param age age
     */
    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get object job title
     */
    @Override
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
     * Set by either the Service or Data layer.
     * @param jobTitle job title 
     */
    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Get object email
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Set by either the Service or Data layer.
     * @param email email
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get object hire date
     */
    @Override
    public Instant getContractHireDate() {
        return this.hireDate;
    }

    /**
     * Set by either the Service or Data layer.
     * @param date hire date
     */
    @Override
    public void setContractHireDate(Instant date) {
        this.hireDate = date;
    }

    /**
     * Get object termination date
     * Nullable.
     * @return null, if Employee has not been terminated.
     */
    @Override
    public Instant getContractTerminationDate() {
        return this.terminationDate;
    }

    /**
     * Set by either the Service or Data layer.
     * @param date termination date
     */
    @Override
    public void setContractTerminationDate(Instant date) {
        this.terminationDate = date;
    }
}