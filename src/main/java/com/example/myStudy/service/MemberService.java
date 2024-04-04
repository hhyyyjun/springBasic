package com.example.myStudy.service;

import com.example.myStudy.domain.Member;
import com.example.myStudy.repository.MemberRepository;

import java.util.List;
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

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        ValidateDuplicateMember(member); //중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    //로직을 메서드로 바로 바꾸는 단축키 window ver -> ctrl + alt + shift + t -> extract method
    private void ValidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //optional을 바로 반환하는 것은 좋지 않다.
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    
    //전체회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    
    //회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
