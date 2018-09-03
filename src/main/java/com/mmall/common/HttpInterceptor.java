package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述:
 * HTTP请求的前后监听
 *
 * @author SupriseMF
 * @create 2018-08-12 11:15
 */

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String STRAT_TIME = "requestStartTime";



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request starting. url : {} , params : {}",url, JsonMapper.obj2String(parameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute(STRAT_TIME,start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String url = request.getRequestURI().toString();
//        long start = (Long)request.getAttribute(STRAT_TIME);
//        long end = System.currentTimeMillis();
//        log.info("request finished. url : {} , cost : {}",url, end - start);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (Long)request.getAttribute(STRAT_TIME);
        long end = System.currentTimeMillis();
        log.info("request completed. url : {} , cost : {}",url, end - start);
    }
}
