package com.hj.todaybb.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberControlller {
    @Autowired
    private final MemberRepository mr;

    @Autowired
    private final MemberService ms;

    @GetMapping("/join")
    String join(){
        return "member/join.html";
    }

    @PostMapping("/join")
    String joinPro(@ModelAttribute Member row){
        int result = ms.join(row);
        if(result == 1){
            System.out.println("회원가입 성공");
        }else{
            System.out.println("회원가입 실패");
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    String login(){
        return "member/login.html";
    }


    @GetMapping("/logout") // Spring Security 는 로그아웃 방법이 기본적으로 POST 이기 때문에 추가한 코드
    public String logout(HttpServletRequest request, HttpServletResponse response){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }

        return "redirect:/";
    }

    @GetMapping("/myPage")
    String myPage() {return "member/myPage.html";}










}
