package com.example.pcf.pcfdemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping("/employees")
    public ResponseEntity getEmployee() {

  //      List<Employee> employeeList = repository.findAll();
       // EmployeeList list = new EmployeeList();
       // list.setEmployeeList(employeeList);
//        Employee emp = new Employee();
//        emp.setEmployeeId(10);
//        emp.setEmployeeAddress("test addtress");
//        emp.setEmployeeName("test name");

        List<Employee> employeeList =  empService.getAllEmployees();
         EmployeeList list = new EmployeeList();
        list.setEmployeeList(employeeList);

        return ResponseEntity.ok(list);

    }
}
