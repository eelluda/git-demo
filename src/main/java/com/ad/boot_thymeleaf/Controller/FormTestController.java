package com.ad.boot_thymeleaf.Controller;

import com.ad.boot_thymeleaf.bean.Users;
import com.ad.boot_thymeleaf.service.UsersService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
public class FormTestController {
    @Autowired
    UsersService usersService;

    @GetMapping("/from_layouts")
    public String from_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile自动封装上传过来的的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：邮箱={}，用户名={}，头像大小={}，生活照数目={}",email,username,headerImg.getSize(),photos.length);
        if(headerImg!=null){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("g:\\cache\\"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("g:\\cache\\"+originalFilename));
                }
            }
        }
        return "main";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                RedirectAttributes ra){
        List<Users> users = usersService.list();
        Page<Users> usersPage = new Page<>(pn, 2);
        //分页查询结果
        Page<Users> page = usersService.page(usersPage, null);
        if(page.getPages() < pn){
            ra.addAttribute("pn",pn-1);
            return "redirect:/dynamic_table";
        }
        model.addAttribute("page",page);
        return "form/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){
        usersService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
}
