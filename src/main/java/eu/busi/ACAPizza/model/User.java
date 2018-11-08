package eu.busi.ACAPizza.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {



    private String username;
    private String lastName;
    private String adress;
    private int zipCode;
    private String email;
    private String password;
    private String phone;


    private List<Order> orders;

    private String authorities ;
    private Boolean non_expired ;
    private Boolean non_locked ;
    private Boolean credentials_non_expired ;
    private Boolean enabled ;

    public User () {}



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getNon_expired() {
        return non_expired;
    }

    public void setNon_expired(Boolean non_expired) {
        this.non_expired = non_expired;
    }

    public Boolean getNon_locked() {
        return non_locked;
    }

    public void setNon_locked(Boolean non_locked) {
        this.non_locked = non_locked;
    }

    public Boolean getCredentials_non_expired() {
        return credentials_non_expired;
    }

    public void setCredentials_non_expired(Boolean credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
