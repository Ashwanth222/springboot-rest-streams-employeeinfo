package com.employeeinfo.employeeinfo.Service;

import com.employeeinfo.employeeinfo.Entity.Employee;
import com.employeeinfo.employeeinfo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployeess() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }

    public String deleteById(int id) {
        employeeRepository.deleteById(id);
        return "Successfully Deleted";

    }
    public Optional<Employee> getName(String name) {
        return employeeRepository.findByName(name);
    }

    public Employee updateEmp(Employee employee, int id) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);

        existingEmployee.setName(employee.getName());
        existingEmployee.setDept(employee.getDept());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setYearOfJoining(employee.getYearOfJoining());

        return employeeRepository.save(existingEmployee);
    }

    public List<Employee> getAllEmployeessGreater() {

        return employeeRepository.findAll().stream().filter(s ->s.getSalary()>5000).collect(Collectors.toList());
    }

    public List<String> getDeptwisesalaryGreater() {

        return employeeRepository.findAll().stream().filter(s ->s.getSalary()>5000).map(e ->e.getDept()).collect(Collectors.toList());

    }

    public
    Optional<Double> getHigestSalaryofEmployee() {

        return employeeRepository.findAll().stream().map(e->e.getSalary()).max((e1,e2) -> e1.compareTo(e2));
    }

    public double getHighestSalaryOfEmployee() {
        return employeeRepository.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().get().getSalary();

        //  .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList()).get(1).getSalary();

    }

    public double getSumOfSalaryhere() {

        return employeeRepository.findAll().stream().collect(Collectors.summingDouble(Employee::getSalary));
    }


    public Map<String, Long> getDeptCOunthere() {

        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

    }

    public List<Employee> gettopempsalaries() {

        return employeeRepository.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5).collect(Collectors.toList());
    }



    public List<Employee> gettopempSalarieshere() {

      //  return employeeRepository.findAll().stream().filter(e -> e.getSalary() <50000 && e.getDept().equals("hydsec")).
           //     sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).map(e->e.getName()).collect(Collectors.toList());

        return employeeRepository.findAll().stream().filter(e -> e.getSalary() <50000 && e.getDept().equals("hydsec")).
                sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());

    }
}


