package com.kms.practice.member.service;

import com.kms.practice.member.dto.MemberDTO;
import com.kms.practice.member.entity.MemberEntity;
import com.kms.practice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public long idCheck(String memberId) {
        return memberRepository.countAllByMemberId(memberId);
    }

    @Override
    public int signup(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity
                .builder()
                .memberId(memberDTO.getMemberId())
                .memberPw(bCryptPasswordEncoder.encode(memberDTO.getMemberPw()))
                .enrollDate(null)
                .deleteYn("n")
                .build();
        log.info(memberEntity.toString());

        int answer = 0;
        MemberEntity result = memberRepository.save(memberEntity);
        log.info(result.toString());

            if(result.getMemberNo() > 0){
                answer = 1;
            }
        return answer;
    }


}
