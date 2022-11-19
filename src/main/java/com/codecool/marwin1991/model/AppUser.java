package com.codecool.marwin1991.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class AppUser {

    // TODO this class should be entity with fields
    //  id; (as String with uuid2 strategy)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    private String name;
    private String email;
    private String imageUri;
    private Boolean emailVerified = false;
    @JsonIgnore
    private String  password =  null;
    private AuthProvider provider;
    private String providerId;

    //  name;
    //  email;
    //  imageUrl;
    //  emailVerified default false;
    //  password default null;
    //  AuthProvider provider;
    //  String providerId;

}
