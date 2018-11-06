package eu.busi.ACAPizza.model;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {


    private int id;

    private String firstName;
    private String lastName;
    private String adress;
    private String zipCode;
    private String email;
    private String password;

    private List<Order> orders;

    private String authorities ;
    private Boolean non_expired ;
    private Boolean non_locked ;
    private Boolean credentials_non_expired ;
    private Boolean enabled ;

    public User () {}




}
