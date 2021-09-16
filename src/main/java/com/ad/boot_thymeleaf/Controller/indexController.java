package com.ad.boot_thymeleaf.Controller;

import com.ad.boot_thymeleaf.bean.User;
import com.ad.boot_thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {
    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/getuser")
    public User getById(@RequestParam("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String mainPage(User user, HttpSession session, Model model){
        //登陆成功重定向到main.html，防止表单重复提交
        if(StringUtils.hasLength(user.getUsername())&&user.getUserpwd().equals("ad")){
            session.setAttribute("loginuser",user);
            return "redirect:/main.html";
        }
        model.addAttribute("msg","账号密码错误！");
        return "login";
    }

    @GetMapping("main.html")
    public String main(HttpSession session){
        if(session.getAttribute("loginuser")!=null)
            return "main";
        else
            return "login";
    }
}
