package com.billcom.drools.repository;

import com.billcom.drools.model.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmpRepository extends MongoRepository<Employees,String> {

}
