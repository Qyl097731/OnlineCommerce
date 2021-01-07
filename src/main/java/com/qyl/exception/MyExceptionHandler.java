package com.qyl.exception;

import com.qyl.exception.admin.AdminLoginNoException;
import com.qyl.exception.before.UserLoginNoException;
import com.qyl.instance.Auser;
import com.qyl.instance.Buser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.exception
 * date: 2020-10-29 18:25
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        Map<String,Object> model = new HashMap<>(100);
        model.put("ex",ex);
        if(ex instanceof AdminLoginNoException){
            request.setAttribute("auser",new Auser());
            request.setAttribute("msg","没有登陆，请登录!");
            return new ModelAndView("/admin/login",model);
        }else if(ex instanceof UserLoginNoException){
            request.setAttribute("buser",new Buser());
            request.setAttribute("msg","没有登陆，请登录!");
            return new ModelAndView("/before/login",model);
        }else{
            return new ModelAndView("/error/error",model);
        }
    }
}