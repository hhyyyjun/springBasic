package com.example.myStudy.service;

import com.example.myStudy.domain.Member;
import com.example.myStudy.repository.MemberRepository;
import com.example.myStudy.repository.MemoryMemberRepository;

import java.util.Optional;

/**
 * packageName    : com.example.myStudy.service
 * fileName       : MemberService
 * author         : hj
 * date           : 2023-07-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-07-06        hj       최초 생성
 */

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        memberRepository.findByName(member.getName()) //optional을 바로 반환하는 것은 좋지 않다.
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();
    }
}
