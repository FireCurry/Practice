package com.kms.practice.member.service;

import com.kms.practice.member.dto.CustomUserDetails;
import com.kms.practice.member.entity.MemberEntity;
import com.kms.practice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Optional<MemberEntity> memberEntity = memberRepository.findByMemberId(memberId);

        if (memberEntity.isPresent()) {
            return new CustomUserDetails(memberEntity.get());
        }

        return null;
    }
}
