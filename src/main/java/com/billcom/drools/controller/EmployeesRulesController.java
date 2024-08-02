package com.billcom.drools.controller;


import com.billcom.drools.model.Employees;
import com.billcom.drools.repository.EmpRepository;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.billcom.drools.service.EmpService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ComponentScan
@RequestMapping("/api/emp")
@Slf4j
public class EmployeesRulesController {
    @Autowired
    private KieSession session;
    @Autowired
    private EmpRepository emprep;


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/Rules")
    public Employees orderNow(@RequestBody Employees rules) {
        session.insert(rules);
        session.fireAllRules();
        return rules;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/post")
    public Employees post(@RequestBody Employees emp) {
        Employees created = service.create(emp);
        return created;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/getAllUser")
    public List<Employees> getAllUser() {
        return emprep.findAll();
    }


/*    @CrossOrigin(origins = "*")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Employees> updatedEmp(@PathVariable String id, @RequestBody Employees emp) {
        Employees E = emprep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        E.setEducation(emp.getEducation());
        E.setJoiningyear(emp.getJoiningyear());
        E.setCity(emp.getCity());
        E.setPaymentTier(emp.getPaymentTier());
        E.setAge(emp.getAge());
        E.setGender(emp.getGender());
        E.setEverBenched(emp.getEverBenched());
        E.setExperienceInCurrentDomain(emp.getExperienceInCurrentDomain());
        E.setLeaveOrNot(emp.getLeaveOrNot());

        Employees updatedEmp = emprep.save(E);
        return ResponseEntity.ok(updatedEmp);
    }
    */
/*
    @CrossOrigin(origins = "*")
    @PutMapping(value = "/updated/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody Employees emp) {
        Optional<Employees> employee = emprep.findById(id);
        log.info("employee : ", employee.toString());
        if (!employee.isPresent()) {
            return new ResponseEntity<>(
                    "employee not found",
                    HttpStatus.BAD_REQUEST
            );
        }
        employee.ifPresent(s -> {
            log.info("employee found");
            s.setEducation(emp.getEducation());
            s.setJoiningyear(emp.getJoiningyear());
            s.setCity(emp.getCity());
            s.setPaymentTier(emp.getPaymentTier());
            s.setAge(emp.getAge());
            s.setGender(emp.getGender());
            s.setEverBenched(emp.getEverBenched());
            s.setExperienceInCurrentDomain(emp.getExperienceInCurrentDomain());
            s.setLeaveOrNot(emp.getLeaveOrNot());

            emprep.save(s);

        });
        return new ResponseEntity<>(
                "Employee Successfully Updated",
                HttpStatus.OK
        );

    }*/
@Autowired
private EmpService service;
@PutMapping("/update/{id}")
public ResponseEntity<Employees> update(
        @PathVariable("id") String id,
        @RequestBody Employees updatedEmp) {

     Optional<Employees> updated = service.update(id, updatedEmp);

    return updated
            .map(value -> ResponseEntity.ok().body(value))
            .orElseGet(() -> {
                Employees created = service.create(updatedEmp);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/update/{id}")
                        .buildAndExpand(created.getId())
                        .toUri();
                return ResponseEntity.created(location).body(created);
            });
}
}

