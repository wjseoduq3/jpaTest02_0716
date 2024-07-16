package com.jdy.jpashop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jpa_membertbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

    @Id // 기본키로 설정
    @Column(name = "membernum") // 실제 DB tbl의 필드 이름
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membernum;

    @Column(name = "memberid", length = 20, nullable = false, unique = true)
    private String memberid;

    @Column(name = "memberpw", length = 20, nullable = false)
    private String memberpw;

    @Column(name = "membername", length = 20, nullable = false)
    private String membername;

    @Column(name = "memberage")
    private int memberage;


}
