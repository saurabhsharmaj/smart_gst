package com.ebit.smartgst.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ebit.smartgst.model.Employee;
 
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
 
    @Query("SELECT e FROM Employee e WHERE e.username = :username")
    public Employee getEmployeeByUsername(@Param("username") String username);
}
