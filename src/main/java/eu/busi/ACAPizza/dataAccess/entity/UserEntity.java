package eu.busi.ACAPizza.dataAccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class UserEntity {


    @Id
    @Column(name="userId")
    private int userId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="adress")
    private String adress;
    @Column(name="zipCode")
    private int zipCode;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy ="client", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    @Column(name="authorities")
    private String authorities ;
    @Column(name="non_expired")
    private Boolean non_expired ;
    @Column(name="non_locked")
    private Boolean non_locked ;
    @Column(name="credentials_non_expired")
    private Boolean credentials_non_expired ;
    @Column(name="enabled")
    private Boolean enabled ;

    public UserEntity() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
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
