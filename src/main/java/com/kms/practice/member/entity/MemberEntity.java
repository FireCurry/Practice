package com.kms.practice.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @Column(unique = true, nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private LocalDateTime enrollDate;

    @Column(nullable = false, length = 1)
    private String deleteYn;

    @Builder
    public MemberEntity(String memberId, String memberPw, LocalDateTime enrollDate, String deleteYn) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.enrollDate = enrollDate;
        this.deleteYn = deleteYn;
    }

}
