package umc.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findMemberByNameAndStatus(String name, MemberStatus status);

    //  직접 작성하기
//    @Query("SELECT m from Member m where m.name = :name and m.status = :status")
//    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);
}


