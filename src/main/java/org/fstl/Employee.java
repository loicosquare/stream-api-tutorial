package org.fstl;

import java.util.List;

public class Employee {

    private String firstname;
    private String lastname;
    private Double salary;
    private List<String> projects;

    public Employee(){}

    public Employee(String firstname, String lastname, Double salary, List<String> projects) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.projects = projects;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }
}
