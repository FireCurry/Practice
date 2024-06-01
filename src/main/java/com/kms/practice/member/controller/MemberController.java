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
        String message = null;
        int result = memberService.signup(memberDTO);
        if(result >0){
            message = "회원가입 성공";
        } else {
            message = "회원가입 실패";
        }
        ra.addFlashAttribute("message", message);
        return "redirect:signin";
    }

    @GetMapping("idCheck")
    @ResponseBody
    public long idCheck(String memberId) {
        return memberService.idCheck(memberId);
    }

//    @PostMapping("signup")
//    public String signup(@ModelAttribute Member member) {
//        memberService.signup(member);
//        return "redirect:/member/signin";
//    }

}
