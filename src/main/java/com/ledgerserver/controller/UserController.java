/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2023/10/13
 */
package com.ledgerserver.controller;

import com.ledgerserver.common.Constants;
import com.ledgerserver.common.Response;
import com.ledgerserver.common.Result;
import com.ledgerserver.common.ResultCode;
import com.ledgerserver.entity.User;
import com.ledgerserver.repository.UserRepository;
import com.ledgerserver.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.TokenUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    /**
     * 注册
     */
    @PostMapping("register")
    public Result register(@RequestBody User user) {
        if(user.username.isEmpty() ||  user.password.isEmpty()) {
            return Response.failure(ResultCode.PARAMS_IS_INVALID);
        }

        boolean isUsernameExists = userRepository.existsByUsername(user.username);

        if(isUsernameExists) {
            return Response.failure(ResultCode.USER_ERROR);
        }

        userService.createUser(user);
        return Response.success("创建成功！");
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        User userinfo = userRepository.findByUsername(user.username);
        Map<String, String> tokenMap = new HashMap<>();
        if(user.username.isEmpty() || user.password.isEmpty()) {
            return Response.failure(ResultCode.PARAMS_USER_IS_BLANK);
        }

        if(!user.username.equals(userinfo.username) && !user.password.equals(userinfo.password)) {
            return Response.failure(ResultCode.USER_OR_PASSWORD_ERROR);
        }

        String token =  TokenUtil.generateToken(user.username);
        if(token.isEmpty()) {
            return Response.failure(ResultCode.TOKEN_ERROR);
        }

        tokenMap.put("token", token);
        return Response.success(tokenMap);
    }

    /**
     * 获取用户信息
     */
    @GetMapping("getUserinfo")
    public Result<User> getUserinfo(HttpServletRequest request) {
        String token = request.getHeader(Constants.AUTHORIZATION);
        System.out.println(token+"tokentokentokentokentoken");
        String username = TokenUtil.getUsernameFormToken(token);
        User userInfo = userRepository.findByUsername(username);
        return Response.success(userInfo);
    }
}
