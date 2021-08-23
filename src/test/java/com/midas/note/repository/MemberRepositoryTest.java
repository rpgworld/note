package com.midas.note.repository;

import com.midas.note.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        Member member = new Member();

        Member memberA = memberRepository.save(member.builder()
                .username("memberA")
                .email("midas@naver.com")
                .build());

        assertEquals(memberA.getId(), member.getId());
        assertEquals(memberA.getUsername(), member.getUsername());
        assertEquals(memberA, member);
    }
}