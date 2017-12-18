/**
 * 
 */
package com.webapp.webRpg.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @클래스명 : SessionIntercepter
 * @작성자 : 신태휘
 * @작성일 : 2017. 12. 18.
 * @설명 : 
 * @수정이력 - 수정일, 수정자, 수정내용
 */
public class SessionIntercepter extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //Session Object에서 user라는 Attribute가 null일경우 accessForm페이지로 이동
            if(request.getSession().getAttribute("mbid") == null ){
                    response.sendRedirect("/");
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //user라는 Attribute가 존재시 요청페이지 이동
        return true;
    }
}
