package com.billcom.drools.service;
import com.billcom.drools.model.Employees;
import com.billcom.drools.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service


public class EmpService {




        @Autowired
        private EmpRepository emprep;

    public Optional<Employees> update(String id, Employees employeeToUpdate) {
        return emprep.findById(id).map(employee -> {
            if (employeeToUpdate.getEducation() != null) {
                employee.setEducation(employeeToUpdate.getEducation());
            }
            if (employeeToUpdate.getJoiningyear() != null) {
                employee.setJoiningyear(employeeToUpdate.getJoiningyear());
            }
            if (employeeToUpdate.getCity() != null) {
                employee.setCity(employeeToUpdate.getCity());
            }
            if (employeeToUpdate.getPaymentTier() != null) {
                employee.setPaymentTier(employeeToUpdate.getPaymentTier());
            }
            if (employeeToUpdate.getAge() != null) {
                employee.setAge(employeeToUpdate.getAge());
            }
            if (employeeToUpdate.getGender() != null) {
                employee.setGender(employeeToUpdate.getGender());
            }
            if (employeeToUpdate.getEverBenched() != null) {
                employee.setEverBenched(employeeToUpdate.getEverBenched());
            }
            if (employeeToUpdate.getExperienceInCurrentDomain() != null) {
                employee.setExperienceInCurrentDomain(employeeToUpdate.getExperienceInCurrentDomain());
            }
            if (employeeToUpdate.getLeaveOrNot() != null) {
                employee.setLeaveOrNot(employeeToUpdate.getLeaveOrNot());
            }
            return emprep.save(employee);
        });
    }

    public Employees create(Employees employeeToCreate) {
        return emprep.save(employeeToCreate);
    }

    public List<Employees> findAll() {
        return emprep.findAll();
    }
}


