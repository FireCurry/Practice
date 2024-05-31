package com.kms.practice.member.controller;

import com.kms.practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("signin")
    public String signin() {
        return "member/signin";
    }

    @GetMapping("signup")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute Member member) {
        memberService.signup(member);
        return "redirect:/member/signin";
    }

}
