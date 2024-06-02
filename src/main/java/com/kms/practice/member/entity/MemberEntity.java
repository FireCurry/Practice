package com.kms.practice.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
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
    @CreationTimestamp
    private LocalDateTime enrollDate;

    @Column(nullable = false, length = 1)
    @ColumnDefault("'n'")
    private String deleteYn;

    @Column(nullable = false)
    @ColumnDefault("'member'")
    private String role;

    @Builder
    public MemberEntity(String memberId, String memberPw, LocalDateTime enrollDate, String deleteYn, String role) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.enrollDate = enrollDate;
        this.deleteYn = deleteYn;
        this.role = role;
    }

}
