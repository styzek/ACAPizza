package eu.busi.ACAPizza.dataAccess.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="client")
public class UserEntity implements UserDetails, Serializable {

    @Id
    @Column(name="username")
    private String username;
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

    @Column(name="non_expired")
    private Boolean accountNonExpired ;
    @Column(name="non_locked")
    private Boolean accountNonLocked ;
    @Column(name="credentials_non_expired")
    private Boolean credentialsNonExpired ;
    @Column(name="enabled")
    private Boolean enable ;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns = {@JoinColumn(name = "fk_user",referencedColumnName = "username")},
            inverseJoinColumns = {@JoinColumn(name = "fk_role",referencedColumnName = "role")}

    )
    private Set<RoleEntity> roles;


    public UserEntity() {}


    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
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



    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }


}
