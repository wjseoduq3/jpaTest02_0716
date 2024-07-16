package com.jdy.jpashop.controller;

import com.jdy.jpashop.entity.Member;
import com.jdy.jpashop.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class JpaController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("data","헬로월드");
        return "helloworld";
    }

    @GetMapping(value = "/info")
    public String info(Model model) {
        Optional<Member> memberOptional = memberRepository.findById(1L);
        Member member = memberOptional.get();

        model.addAttribute("member", member);

        return "info";
    }

    @GetMapping(value = "/linkTest")
    public  String linkTest() {
        return "linkTest";
    }

    @GetMapping(value = "/loginOk")
    public String loginOk(HttpServletRequest request, Model model) {
        model.addAttribute("id", request.getParameter("id"));
        model.addAttribute("pw", request.getParameter("pw"));

        return "loginOk";
    }

    @GetMapping(value = "/ifTest")
    public String ifTest(Model model) {
        Optional<Member> memberOptional = memberRepository.findById(1L);
        Member member = memberOptional.get();

        model.addAttribute("member", member);

        return  "ifTest";
    }

    @GetMapping(value = "/members")
    public String members(Model model) {
        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "eachList";
    }

    @GetMapping(value = "/content")
    public  String content() {
       return "content";
    }

}
