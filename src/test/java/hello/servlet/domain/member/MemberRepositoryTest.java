package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("kim", 18);

        // when
        Member result = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findMemberById(result.getId());
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }

    @Test
    void findAll() {
        // given
        Member kim = new Member("kim", 20);
        Member kwon = new Member("kwon", 23);
        Member save1 = memberRepository.save(kim);
        Member save2 = memberRepository.save(kwon);

        // when
        List<Member> all = memberRepository.findAll();

        // then
        Assertions.assertThat(all.size()).isEqualTo(2);
        Assertions.assertThat(all).contains(kim, kwon);
    }
}