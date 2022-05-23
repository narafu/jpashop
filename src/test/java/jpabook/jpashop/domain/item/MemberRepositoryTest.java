package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() {

        // given
        Member member = new Member();
        member.setName("memberA");

        // when
        Long saveId = memberRepository.save(member);// 저장
        Member findMember = memberRepository.findOne(saveId); // 저장하고 리턴 받은 아이디로 다시 조회

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId()); // 다시 조회한 아이디와 원래 저장한 아이디 비교
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName()); // 다시 조회한 이름과 원래 저장한 이름 비교

    }

}