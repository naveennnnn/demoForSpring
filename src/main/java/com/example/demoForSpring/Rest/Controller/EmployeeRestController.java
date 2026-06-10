package com.example.demoForSpring.Rest.Controller;

import com.example.util.Coach;

import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoForSpring.Models_entity.Employee;
import com.example.demoForSpring.Rest.Service.EmployeeService;
import com.example.demoForSpring.dao.EmployeeDao;


//---------------------------------THe restApi's will be taken care by the JPAReposity and adding data-rest in pom.xml
//the free apis are given by spring boot and the api's will be the plural form of the entity we give in the JPAReposity<entity,primary_key_dataType>



@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private JsonMapper jsonMapper;
    
    private final Coach aquatic;
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService, Coach aquatic, JsonMapper map) {
        this.employeeService = employeeService;
        this.aquatic = aquatic;
        this.jsonMapper = map;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        List<Employee> ls = employeeService.findAll();
        return ls;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee emp = employeeService.findById(employeeId);
        
        if(emp==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){

        // We have to set the primary key of employee to 0 so that a new object is saved instead of update.
        employee.setId(null); // if this was a wrapper class(Integer) then we have to set it to null.
        Employee emp = employeeService.save(employee);

        return emp;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        Employee emp = employeeService.save(employee);
        return emp;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patch(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayload){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id cannot be updated");
        }

        Employee patchedEmp = jsonMapper.updateValue(tempEmployee, patchPayload);

        Employee dbEmp = employeeService.save(patchedEmp);

        return dbEmp;
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId){
        Employee emp = employeeService.findById(employeeId);

        if(emp == null){
            throw new RuntimeException("Entered Emp Id is invalid");
        }

        employeeService.delete(employeeId);

        return "THe employee is deleted";
    }
}
