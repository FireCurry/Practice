package com.kms.practice.member.service;

import com.kms.practice.member.dto.MemberDTO;
import com.kms.practice.member.entity.MemberEntity;
import com.kms.practice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int idCheck(String memberId) {
        return memberRepository.countAllByMemberId(memberId);
    }

    @Override
    public int signup(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity()
                .builder()
                .memberId(memberDTO.getMemberId())
                .memberPw(bCryptPasswordEncoder.encode(memberDTO.getMemberPw()))
                .enrollDate(null)
                .deleteYn(null)
                .build();
        try{
            MemberEntity result = memberRepository.save(memberEntity);
            if(result.getMemberNo() > 0){
                return 1;
            }
        } catch (Exception exception){
            return 0;
        }
    }


}
