package com.jdy.jpashop.repository;

import com.jdy.jpashop.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByMembername(String membername);
    public List<Member> findByMembernameContaining(String membername);
    public List<Member> findByMembernameOrderByMemberageDesc(String membername);//회원 이름으로 검색 후 나이 내림차순 정렬
    public List<Member> findAllbyOrderByMemberageDesc();

    @Transactional
    public void deleteAllByMembername(String membername);



}
