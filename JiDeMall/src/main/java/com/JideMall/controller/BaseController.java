package com.JideMall.controller;

import com.JideMall.service.exception.*;
import com.JideMall.util.JsonResult;
import com.JideMall.service.exception.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制层类的基类
 */
public class BaseController {
    public static final Integer OK=200;

    @ExceptionHandler({ServiceException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMsg("用户名已存在！");
        }else if(e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMsg("用户不存在！");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMsg("用户名密码错误！");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMsg("注册时产生未知错误！");
        }else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMsg("更新数据时产生未知错误！");
        }
        return result;
    }
    /**
     * 获取session对象中的uid
     * @param session
     * @return
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取当前登录用户的名字
     * @return
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

}
