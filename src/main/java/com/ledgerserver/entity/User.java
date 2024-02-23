/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/20
 */
package com.ledgerserver.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ctime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date ctime;

    public String username;
    public String password;
    private String signature;
    private String avatar;
}
