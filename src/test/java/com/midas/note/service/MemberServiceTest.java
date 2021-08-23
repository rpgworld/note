package com.midas.note.service;

import com.midas.note.domain.Member;
import com.midas.note.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
public class MemberServiceTest {
//    @Autowired MemberService memberService;
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void 회원가입() throws Exception {
//
//        // Given
//        Member member = new Member();
//        member.setUsername("kim");
//        member.setEmail("hoit@naver.com");
//
//        // When
//        Long saveId = memberService.join(member);
//
//        // Then
//        assertEquals(member, memberRepository.findOne(saveId));
//    }
//
//    @Test
//    public void 중복_회원_예외() throws Exception {
//
//        // Given
//        Member member1 = new Member();
//        member1.setUsername("kim");
//
//        Member member2 = new Member();
//        member2.setUsername("kim");
//
//        // When
//        memberService.join(member1);
//
//        // Then
//        assertThrows(IllegalStateException.class, ()-> {
//            memberService.join(member2);
//        });
//    }
}