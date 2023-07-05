package com.example.myStudy.repository;

import com.example.myStudy.domain.Member;

import java.util.*;

/**
 * packageName    : com.example.myStudy.repository
 * fileName       : MemoryMemberRepository
 * author         : hj
 * date           : 2023-07-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-07-05        hj       최초 생성
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  //키 값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null값 방지
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //넘어온 파라미터 name과 같은지 확인
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member에 있는 데이터 리턴
    }

    public void clearStore(){
        store.clear();
    }
}
