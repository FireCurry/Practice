package com.kms.practice.member.repository;

import com.kms.practice.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    int countAllByMemberId(String memberId);

    Optional<MemberEntity> findByMemberId(String memberId);
}
