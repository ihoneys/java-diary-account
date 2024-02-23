/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/21
 */
package com.ledgerserver.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int payType;
    private int typeId;
    private int userId;
    private String date;
    private String amount;
    private String typeName;
    private String remark;
}
