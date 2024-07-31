package com.billcom.drools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Calendar;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    @Id
    @Getter
    @Setter
    @Field(name = "_id")
    private String _id;



    @Getter
    @Setter
    @Field(name = "Education")
    private String education;

    @Getter
    @Setter
    @Field(name = "JoiningYear")
    private Integer joiningyear;

    @Getter
    @Setter
    @Field(name = "City")
    private String city;

    @Getter
    @Setter
    @Field(name = "PaymentTier")
    private Integer paymentTier;

    @Getter
    @Setter
    @Field(name = "Age")
    private Integer age;
    @Getter
    @Setter
    @Field(name = "Gender")
    private String gender;


    @Getter
    @Setter
    @Field(name = "EverBenched")
    private String everBenched;

    @Getter
    @Setter
    @Field(name = "ExperienceInCurrentDomain")
    private Integer experienceInCurrentDomain;

    @Getter
    @Setter
    @Field(name = "LeaveOrNot")
    private Integer leaveOrNot;
    public String getId() {
        return _id;
    }



}
