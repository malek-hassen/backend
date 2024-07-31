package com.billcom.drools.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	@Field(name="name")
    private String name;
	
	@Field(name="rollNumber")
    private String rollNumber;
  
}
   