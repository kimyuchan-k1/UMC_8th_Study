package umc.spring.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.mapping.MemberPrefer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager em;


    /**
     * MemberTest class
     * 멤버를 조회하기 테스트
     */
    @BeforeEach
    void init() {

        Address address = new Address("Seoul", "Gangnam");

        // FoodCategory 객체 생성 및 영속화
        FoodCategory foodCategory = FoodCategory.builder()
                .name("한식")
                .build();
        em.persist(foodCategory); // FoodCategory를 먼저 영속화

        //memberPrefer 객체 생성 및 영속화
        MemberPrefer memberPrefer = MemberPrefer.builder()
                .foodCategory(foodCategory)
                .build();

        em.persist(memberPrefer); // MemberPrefer를 먼저 영속화


        // MemberPrefer 리스트 생성
        ArrayList<MemberPrefer> memberPreferList = new ArrayList<>();
        memberPreferList.add(memberPrefer);

        // Member 객체 생성
        Member member = Member.builder()
                .name("memberA")
                .address(address) // 필수 필드 설정
                .email("memberA@example.com") // 필수 필드 설정
                .memberPreferList(memberPreferList)
                .build();

        // MemberPersist
        em.persist(member);
        em.flush();


    }

    @Test
    void test() {
        Member member = em.find(Member.class, 1L);
        assertEquals("memberA", member.getName());
        assertEquals(1, member.getMemberPreferList().size());
    }


}