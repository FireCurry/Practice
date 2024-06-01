package com.kms.practice.member.repository;

import com.kms.practice.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    int findByMemberId(String memberId);
}
