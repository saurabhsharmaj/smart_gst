package com.ebit.smartgst.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ebit.smartgst.model.Dept;

public interface DeptRepository extends CrudRepository<Dept, Long> {
 
    @Query("SELECT d FROM Dept d WHERE d.name = :name")
    public Dept getDeptByName(@Param("name") String username);
}
