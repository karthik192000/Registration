package com.registration.application.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_details",schema = "finaleval")
public class UserDetails {


    @Id
    @SequenceGenerator(name = "user_id_sequence", sequenceName = "finaleval.user_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    private Integer userid;


    private String name;

    private String email;


    private String username;


    private Long phonenumber;

    private String passwrd;

    private String gender;

    public UserDetails(){
        //Empty Constructor
    }

    public UserDetails(String name, String email, String username, Long phonenumber, String passwrd, String gender) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.phonenumber = phonenumber;
        this.passwrd = passwrd;
        this.gender = gender;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
