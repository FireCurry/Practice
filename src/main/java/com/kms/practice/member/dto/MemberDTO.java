package com.kms.practice.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private Long memberNo;
    private String memberId;
    private String memberPw;
    private LocalDateTime enrollDate;
    private String deleteYn;
}
