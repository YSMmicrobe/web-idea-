package com.baizhi.action;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baizhi.entity.User;
import com.baizhi.service.IUserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MailUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;

public class UserAction {
    private IUserService userService = new UserServiceImpl();
    private User user;
    private Integer number;
    private String  code;

    /**
     * 测试用Ajax登录
     * @return
     */
    public void ajaxLogin(){

    }

    public String login(){
        User user1 = userService.selectByEmail(this.user.getEmail());
        if (user1!=null && user1.getPassword().equals(user.getPassword())){
            ServletActionContext.getRequest().getSession().setAttribute("user",user1);
            return "login";
        }else{
            return "errorLogin";
        }
    }

    public String register(){

        String  realCode = (String) ServletActionContext.getRequest().getSession().getAttribute("code");
        if (code.equalsIgnoreCase(realCode)){
            userService.insertOne(user);
            MailUtil.sendSimpleMail("574432753@qq.com",
                    "当当网注册账号",
                    "当当网邀请您注册账号  " +
                            " <a href='http://localhost:8989/DangDangWang/user/email?user.email="+user.getEmail()+"'>注册</a>");
            return "register";
        }else{
            return "errorCode";
        }
    }

    public String userExcite(){
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        ServletActionContext.getRequest().getSession().removeAttribute("cart");
        return "login";
    }


    public String email(){
        userService.updateSta(user.getEmail());
        User user1 = userService.selectByEmail(user.getEmail());
        ServletActionContext.getRequest().getSession().setAttribute("user",user1);
        return "email";
    }
    public void createCode() throws Exception {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 20);
        ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
        lineCaptcha.write(outputStream);
        outputStream.close();

        ServletActionContext.getRequest().getSession().setAttribute("code",lineCaptcha.getCode());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
