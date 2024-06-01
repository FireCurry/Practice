package com.kms.practice.member.service;

import com.kms.practice.member.dto.MemberDTO;

public interface MemberService {

    int idCheck(String memberId);

    int signup(MemberDTO memberDTO);
}
