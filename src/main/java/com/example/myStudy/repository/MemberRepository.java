package com.example.myStudy.repository;

import com.example.myStudy.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.example.myStudy.repository
 * fileName       : MemberRepository
 * author         : hj
 * date           : 2023-07-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-07-05        hj       최초 생성
 */
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
