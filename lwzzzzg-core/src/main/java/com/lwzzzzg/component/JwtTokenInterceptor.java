package com.lwzzzzg.component;

import com.alibaba.fastjson.JSONObject;
import com.lwzzzzg.annotations.LoginUser;
import com.lwzzzzg.result.ResultEnum;
import com.lwzzzzg.result.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

//@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginUser loginUser = method.getAnnotation(LoginUser.class);
        if(loginUser != null) {
            System.out.println("获取tokenHeader:" + tokenHeader);
            String authHeader = request.getHeader(tokenHeader);
            System.out.println("获取authHeader:" + authHeader);
            if(StringUtils.isEmpty(authHeader) || !authHeader.startsWith(tokenHead)) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter writer = response.getWriter();
                writer.print(JSONObject.toJSONString(ResultVo.failed(ResultEnum.TOKEN_ERROR)));
                return false;
            }
            String token = authHeader.substring(this.tokenHead.length());
            System.out.println("获取tokenHead:" + tokenHead);
            System.out.println("获取token:" + token);
            Long userId = jwtHelper.getUserIdFromToken(token);
            if(ObjectUtils.isEmpty(userId)) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter writer = response.getWriter();
                writer.print(JSONObject.toJSONString(ResultVo.failed(ResultEnum.TOKEN_ERROR)));
                return false;
            }
            request.setAttribute("loginUserId", userId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
