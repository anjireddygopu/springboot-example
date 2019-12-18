package com.p3.SpringExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }
     
    public Employee getEmployeeById(Long id)  
    {
        Optional<Employee> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        }
		return employee.get(); 
    }
     
    public Employee createOrUpdateEmployee(Employee entity) 
    {
        Optional<Employee> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Employee newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteEmployeeById(Long id)
    {
        Optional<Employee> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } 
    } 
}
