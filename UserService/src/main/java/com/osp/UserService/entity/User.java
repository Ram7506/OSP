package com.osp.UserService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int userId;
    @Column(unique = true)
    private String name;
    private String email;
    private long phoneNo;
    private String address;
    private List<String> role;

}

