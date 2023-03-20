package com.providerService.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long providerId;
    private String providerName;
    @Column(unique = true)
    private String userName;
    private String password;
    private long phoneNo;
    private String address;
    private String email;
    private List<String> role;


}
