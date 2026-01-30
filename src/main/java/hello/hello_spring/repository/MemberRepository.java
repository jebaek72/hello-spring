package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
//    4가지 기능 생성
    Member save(Member member); // 저장소에 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
