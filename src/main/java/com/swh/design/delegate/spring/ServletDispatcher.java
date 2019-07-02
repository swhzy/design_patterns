package com.swh.design.delegate.spring;

import com.swh.design.delegate.spring.controller.MemberController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServletDispatcher {
    // 维护了所有的Controller与uri的映射信息
    List<Handler> handlers = new ArrayList<Handler>();

    public ServletDispatcher(List<Handler> handlers) {
        Class<MemberController> memberControllerClass = MemberController.class;
        try {
            handlers.add(
                    new Handler().setController(memberControllerClass.newInstance())
                            .setMethod(memberControllerClass.getMethod("login",new Class[]{String.class}))
                            .setUrl("/member/login")
            );
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void doServlet(HttpServletRequest request, HttpServletResponse response){
        doDispatcher(request,response);
    }

    private void doDispatcher(HttpServletRequest request,HttpServletResponse response){
        //  获取用户请求的URL
        String requestURI = request.getRequestURI();
        // 选择需要分发给哪个控制器
        Handler handler = null;
        for (Handler h : handlers) {
            if(handler.url.equals(requestURI)){
                handler = h;
                break;
            }
        }

        try {
            // 执行控制器  让控制器干活
            Object aa = handler.method.invoke(handler.controller, request.getParameter("aa"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }




    class Handler {
        private Object controller;

        private Method method;

        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
