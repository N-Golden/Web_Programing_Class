package org.example.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Setter
@Getter
public class User implements Serializable {
    private int id;
    private String email;
    private String username;
    private String fullName;
    private String password;
    private String avatar;
    private int roleid;
    private String phone;
    private Date createdDate;

    public User(){

    }

    public User(String email, String password, String username, String fullname, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullname;
        this.phone = phone;
    }


}
