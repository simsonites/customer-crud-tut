package com.jvstutcode.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @NaturalId(mutable = true)
    private  String mobile;
    @NaturalId(mutable = true)
    private String email;

    private String country;
    private String city;
    private String address;

}
