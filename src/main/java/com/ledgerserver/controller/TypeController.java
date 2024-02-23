/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/22
 */
package com.ledgerserver.controller;

import com.ledgerserver.common.Response;
import com.ledgerserver.common.Result;
import com.ledgerserver.entity.Type;
import com.ledgerserver.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("list")
    public Result<List<Type>> getTypeList() {

        return Response.success(typeRepository.findAll());
    }
}
