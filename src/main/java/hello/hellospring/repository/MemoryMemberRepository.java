package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // <key, value> 회원을 저장
    private static long sequence = 0L; // key 값 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id세팅
        store.put(member.getId(), member); // store에 id 저장
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 이름이 같은지 확인
                .findAny();
    }
    public void clearStore() {
        store.clear(); // store 비우기
    }
}