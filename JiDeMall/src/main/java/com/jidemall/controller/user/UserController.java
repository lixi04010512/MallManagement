package com.jidemall.controller.user;

import com.jidemall.entity.User;
import com.jidemall.service.UserService;
import com.jidemall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("register_html")
    public String register_html(){
        return "register";
    }

    @RequestMapping("login_html")
    public String login_html(){
        return "login";
    }

    @RequestMapping("about-us_html")
    public String aboutus_html(){
        return "about-us";
    }

    @RequestMapping("account_html")
    public String account_html(){
        return "account";
    }

    @RequestMapping("account-order-history_html")
    public String accountorderhistory_html(){
        return "account-order-history";
    }

    @RequestMapping("account-payment_html")
    public String accountpayment_html(){
        return "account-payment";
    }

    @RequestMapping("add_html")
    public String add_html(){
        return "add";
    }

    @RequestMapping("adlogin_html")
    public String adlogin_html(){
        return "adlogin";
    }

    @RequestMapping("alter_html")
    public String alter_html(){
        return "alter";
    }

    @RequestMapping("checkout_html")
    public String checkout_html(){
        return "checkout";
    }

    @RequestMapping("contact-us_html")
    public String contactus_html(){
        return "contact-us";
    }

    @RequestMapping("index_html")
    public String index_html(){
        return "index";
    }

    @RequestMapping("order-compl eted_html")
    public String ordercompleted_html(){
        return "order-completed";
    }

    @RequestMapping("payment_html")
    public String payment_html(){
        return "payment";
    }
    @RequestMapping("product-view_html")
    public String productview_html(){
        return "product-view";
    }
    @RequestMapping("shop-list_html")
    public String shoplist_html(){
        return "shop-list";
    }

    @RequestMapping("table_html")
    public String table_html(){
        return "table";
    }

    @RequestMapping("terms-condition_html")
    public String termscondition_html(){
        return "terms-condition";
    }

    @ResponseBody
    @RequestMapping("send")
    public JsonResult<Void> send(String email){
        userService.sendEmail(email);
        return new JsonResult<>(OK);
    }
    @ResponseBody
    @RequestMapping("test_email_code")
    public JsonResult<Void> test_code(String code){
        userService.test_code(code);
        return  new JsonResult<>(OK);
    }
    @ResponseBody
    @RequestMapping("regist")
    public JsonResult<Void> regist(User user){
        userService.regist(user);
        return new JsonResult<>(OK);
    }
    @ResponseBody
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User login = userService.login(username, password);
        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());

        System.out.println("用户id："+getUidFromSession(session)+"密码："+getUsernameFromSession(session));
        return new JsonResult<User>(OK,login);
    }
    @ResponseBody
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<Void>(OK);
    }
    @ResponseBody
    @RequestMapping("getInfo")
    public JsonResult<User> getInfo(HttpSession session){
        User user = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK, user);
    }
    @ResponseBody
    @RequestMapping("changeInfo")
    public JsonResult<Void> changeInfo(HttpSession session,User user){
        userService.changeInfo(getUidFromSession(session),getUsernameFromSession(session),user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("recharge")
    public JsonResult<Void> recharge(BigDecimal money, HttpSession session){
        userService.recharge(getUidFromSession(session),money);
        return new JsonResult<>(OK);
    }



}
