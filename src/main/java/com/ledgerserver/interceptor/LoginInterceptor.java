/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/21
 */
package com.ledgerserver.interceptor;

import com.ledgerserver.common.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import utils.TokenUtil;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截 request ---- preHandle");
        String url = request.getRequestURI();
        System.out.println("当前访问url：" + url);

        String token = request.getHeader(Constants.AUTHORIZATION);
        boolean isVerifyToken = TokenUtil.validateToken(token);
        if(!isVerifyToken) {
            throw new RuntimeException("The user login token is invalid！");
        }

        return true;
    }
}
