package com.kms.practice.member.controller;

import com.kms.practice.member.dto.MemberDTO;
import com.kms.practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String signup(@ModelAttribute MemberDTO memberDTO, RedirectAttributes ra){

        int result = memberService.signup(memberDTO);

        ra.addFlashAttribute("message", "회원가입 성공");
        return "redirect:/";
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
