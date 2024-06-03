package com.kms.practice.jwt;

import com.kms.practice.member.dto.CustomUserDetails;
import com.kms.practice.member.entity.MemberEntity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {

            log.info("token null");
            filterChain.doFilter(request, response);

            return;
        }

        log.info("authorization now");

        String token = authorization.substring("Bearer ".length());

        if(jwtUtil.isExpired(token)){

            log.info("token expired");
            filterChain.doFilter(request, response);

            return;
        }

        String memberId = jwtUtil.getMemberId(token);
        String role = jwtUtil.getRole(token);

        MemberEntity memberEntity = MemberEntity.builder()
                .memberId(memberId)
                .memberPw("temppassword")
                .role(role)
                .build();

        CustomUserDetails customUserDetails = new CustomUserDetails(memberEntity);

        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }

}
