package com.kms.practice.member.service;

import com.kms.practice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public int idCheck(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }

}
