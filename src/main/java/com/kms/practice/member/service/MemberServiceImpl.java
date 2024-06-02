package com.kms.practice.member.service;

import com.kms.practice.member.dto.MemberDTO;
import com.kms.practice.member.entity.MemberEntity;
import com.kms.practice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
                .role("'default'")
                .build();

        int answer = 0;
        MemberEntity result = memberRepository.save(memberEntity);

            if(result.getMemberNo() > 0){
                answer = 1;
            }
        return answer;
    }

    @Override
    public int signin(MemberDTO memberDTO) {
        Optional<MemberEntity> result = memberRepository.findByMemberId(memberDTO.getMemberId());

        if(result.isPresent()){
            MemberEntity memberEntity = result.get();
            if(bCryptPasswordEncoder.matches(memberDTO.getMemberPw(), memberEntity.getMemberPw())){
                return 1;
            }
        }

        return 0;
    }


}
