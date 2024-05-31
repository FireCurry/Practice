package com.kms.practice.member.controller;

import com.kms.practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("idCheck")
    @ResponseBody
    public int idCheck(String memberId) {

        return memberService.idCheck(memberId);
    }

//    @PostMapping("signup")
//    public String signup(@ModelAttribute Member member) {
//        memberService.signup(member);
//        return "redirect:/member/signin";
//    }

}
