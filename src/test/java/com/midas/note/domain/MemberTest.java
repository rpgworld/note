package com.midas.note.domain;

import com.midas.note.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 생성일자테스트() throws Exception {
        // given
        Member member = new Member();
        memberRepository.save(member.builder()
                .username("memberA")
                .email("midas@naver.com")
                .build());

        Thread.sleep(100);

        // when
        Member findMember = memberRepository.findById(member.getId()).get();

        // then
        System.out.println(findMember.getCreatedDate());
    }
}