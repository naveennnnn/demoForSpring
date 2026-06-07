package com.example.demoForSpring.Rest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoForSpring.Models_entity.Employee;
import com.example.demoForSpring.dao.EmployeeDao;
import com.example.demoForSpring.dao.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // private EmployeeDao employeeDao;

    private EmployeeRepository empRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public List<Employee> findAll() {
        return empRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> opRes = empRepo.findById(id);

        Employee theEmployee = null;
        if(opRes.isPresent() == true){
            theEmployee = opRes.get();
        }
        else{
            throw new RuntimeException("No employee with provided ID : "+id+" exist.");
        }
        return theEmployee;
    }

    @Override
    // @Transactional // the @Transactional annotation is used in the service layer instead of the DAO layer.
    public Employee save(Employee theEmployee) {
        return empRepo.save(theEmployee);
    }

    @Override
    // @Transactional // This is handled by the JPARepository, hence no need to add it explicitly.
    public void delete(int id) {
        empRepo.deleteById(id);
    }
    
}
