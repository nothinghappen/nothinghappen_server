package Interceptor;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;
import utils.helpers.Userhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangjin on 17/3/17.
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private Userhelper userhelper;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (!checkAuth(httpServletRequest,httpServletResponse)){
            httpServletResponse.setStatus(401);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean checkAuth(HttpServletRequest request,HttpServletResponse response){
        //String auth = request.getParameter("token");
        String auth = request.getHeader("Authorization");
        if (auth == null || auth.length() == 0)
            return false;
        User user = userhelper.getUserByToken(auth);
        return !(user == null);
    }


}
