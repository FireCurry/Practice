package com.kms.practice.member.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @Column(unique = true, nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private Date enrollDate;

    private Character deleteYn;

    @Builder
    public MemberEntity(String memberId, String memberPw, Date enrollDate, Character deleteYn) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.enrollDate = enrollDate;
        this.deleteYn = deleteYn;

    }


}
