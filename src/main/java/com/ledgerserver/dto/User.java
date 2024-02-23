/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2023/10/13
 */
package com.ledgerserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
}
