/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/22
 */
package com.ledgerserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "type")
public class Type {
    @Id
    private long id;
    private long type;
    private long user_id;
    private String name;
}
