package com.example.clase7ws.repository;

import com.example.clase7ws.entity.Employee;
import com.example.clase7ws.entity.Projections.EmployeeWithId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "employee", excerptProjection = EmployeeWithId.class)
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query(value = "SELECT * FROM employees WHERE employee_id>100;",nativeQuery = true)
    List<Employee> listaSinPresi();

    @Query(value = "SELECT * FROM employees WHERE employee_id= ?1 ;",nativeQuery = true)
    List<Employee> empleado(int id);

}