package com.sparta.springcore.controller;

import com.sparta.springcore.domain.UserRoleEnum;
import com.sparta.springcore.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        // 상품조회 (관리자용) 구현 "관리자" 회원 에 대한 처리
        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        //  관리자인 경우에만 model 값 ("admin_role" : true ) 추가
        }

        return "index";
    }
}
