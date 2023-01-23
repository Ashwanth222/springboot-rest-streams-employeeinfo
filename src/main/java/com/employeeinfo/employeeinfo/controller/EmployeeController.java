package com.employeeinfo.employeeinfo.controller;


import com.employeeinfo.employeeinfo.Entity.Employee;
import com.employeeinfo.employeeinfo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){

        return service.createEmployee(employee);
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){

        return service.getAllEmployeess();
    }

    @GetMapping("/allEmployeesGreater")
    public List<Employee> getAllEmployeesGreaterThan(){

        return service.getAllEmployeessGreater();
    }

    @GetMapping("/getAllDeptNameSalaryGreaterThan5000")

    public List<String> getAllDeptSalaryGreaterthanSomething(){

        return service.getDeptwisesalaryGreater();
    }

    @GetMapping("/GetHighestSalary")

    public Optional<Double> GetHighestsalaryofEMployee(){

        return service.getHigestSalaryofEmployee();
    }

    @GetMapping("/GetSecondHighestSalary")

    public double GetsecondHighestSalaryHere(){

        return service.getHighestSalaryOfEmployee();
    }

    @GetMapping("/SumOfSalary")

    public double GetSumOfSalary(){

        return service.getSumOfSalaryhere();
    }

    @GetMapping("/GetDeptCount")

    public Map<String, Long> GetDeptCount(){
        return service.getDeptCOunthere();
    }

    @GetMapping("/Top5Salaries")

    public List<Employee> Gettopempoyeessalaries(){
        return service.gettopempsalaries();
    }

    @GetMapping("/Top5Streams")

    public
    List
            <Employee> GetTopEmployee(){
        return service.gettopempSalarieshere();
    }

    @GetMapping("/getById/{id}")
    public Optional<Employee> getById(@PathVariable int id){

        return service.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){

         service.deleteById(id);
         return  "Successfully Deleted";
    }

    @GetMapping("/getByName/{name}")
    public Optional<Employee> getName(@PathVariable String name){
        return service.getName(name);
    }


    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmp(@RequestBody Employee employee,@PathVariable("id")int id){

      return service.updateEmp(employee,id);
    }

}
