package com.employeeinfo.employeeinfo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeinfo.employeeinfo.Entity.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    Optional<Employee> findByName(String name);

}
