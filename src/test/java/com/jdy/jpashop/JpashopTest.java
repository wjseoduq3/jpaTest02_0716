package com.jdy.jpashop;


import com.jdy.jpashop.entity.Member;
import com.jdy.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JpashopTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입기능테스트")
    public void joinMember() {

        Member member = new Member();
        member.setMemberid("gary4");
        member.setMemberpw("1111");
        member.setMembername("이순신");
        member.setMemberage(55);

        Member savedMember = memberRepository.save(member); //insert문 실행
        System.out.println(savedMember.toString());
    }

    @Test
    @DisplayName("기본키: 회원번호로 검색 테스트")
    public void memberNumSearch() {
        Optional<Member> memberOptional = memberRepository.findById(2L);
        // Optional type 반환값은 null값이 와도 error 안나고 null 값 그대로 저장
        assertTrue(memberOptional.isPresent()); // null 인지 아닌지 확인 가능
        Member member = memberOptional.get();
        System.out.println(member.getMembername());

    }


    @Test
    @DisplayName("회원이름으로 검색")
    public void memberNameSearch() {
        List<Member> memberList = memberRepository.findByMembername("이순신");

        for (Member member:memberList) {
            System.out.println(member.getMemberid());
            System.out.println(member.getMembername());
        }
    }

    @Test
    @DisplayName("모든 회원 검색")
    public void allMemberList() {
        List<Member> alMemberList = memberRepository.findAll();
        for (Member member:alMemberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getMemberage() + " / ");
        }
    }

    @Test
    @DisplayName("특정글자포함 회원 검색")
    public void firstNameSearch() {
        List<Member> memberList = memberRepository.findByMembernameContaining("이");
        for (Member member:memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getMemberage() + " / ");
        }
    }

    @Test
    @DisplayName("회원이름으로 검색 후 나이의 내림차순 정렬")
    public void nameSearch2() {
        List<Member> memberList = memberRepository.findByMembernameOrderByMemberageDesc("이순신");
        for (Member member : memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getMemberage() + " / ");
        }

    }



    @Test
    @DisplayName("회원목록 검색 후 나이의 내림차순 정렬")
    public void memberSearch2() {
        List<Member> memberList = memberRepository.findAllbyOrderByMemberageDesc();
        for (Member member : memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getMemberage() + " / ");
        }

    }

    @Test
    @DisplayName("회원정보 수정")
    public void modifyMember() {
        Optional<Member> memberOptional = memberRepository.findById(2L);

        assertTrue(memberOptional.isPresent());

        Member member = memberOptional.get();
        member.setMembername("강감찬");
        Member savedMember = memberRepository.save(member);
        System.out.println(savedMember.toString());

    }

    @Test
    @DisplayName("회원번호로 삭제")
    public void deleteMember() {
        allMemberList();
        memberRepository.deleteById(4L);
        allMemberList();

    }

    @Test
    @DisplayName("회원이름으로 삭제")
    public void deleteMember2() {
        allMemberList();
        memberRepository.deleteAllByMembername("계백");
        allMemberList();

    }

}
