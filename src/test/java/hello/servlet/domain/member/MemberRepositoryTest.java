package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("멤버 저장테스트")
    void save() {
        //given
        Member member = new Member("hello",20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findById() {
    }

    @Test
    @DisplayName("전체 멤버 테스트")
    void findAll() {
        //given
        Member member1 = new Member("Park",37);
        Member member2 = new Member("Lee", 61);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1,member2);
    }

    @Test
    void clearStore() {
    }
}