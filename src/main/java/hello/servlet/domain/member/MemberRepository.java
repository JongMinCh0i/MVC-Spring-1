package hello.servlet.domain.member;

import java.util.*;


/*
    동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */


// singleton
public class MemberRepository {

    // static 사용
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    // 생성된 인스턴스 (private : 외부에서 호출 불가능 // 호출은 오직 getInstance 통해서만)
    private static final MemberRepository instance = new MemberRepository();

    // 인스턴스 호출용
    public static MemberRepository getInstance() {
        return instance;
    }

    // 기본 생성자
    private MemberRepository() {
    }


    public Member save(Member member) {

        member.setId(++sequence);  // 순차적으로 아이디++

        store.put(member.getId(), member); // member id++ , member 객체 입력

        return member;                     // return member
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        //  new ArrayList<> 를 사용하여 값을 넘겨준다
        //  Why? store.values() 를 건드리고 싶지 않아서 즉, store 자체를 보호하기 위해
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}