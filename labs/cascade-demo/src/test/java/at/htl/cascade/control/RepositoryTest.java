package at.htl.cascade.control;

import at.htl.cascade.entity.A;
import at.htl.cascade.entity.B;
import at.htl.cascade.entity.C;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class RepositoryTest {

    @Inject
    ARepository aRepository;

    @Inject
    BRepository bRepository;

    @Inject
    CRepository cRepository;

    @Test
    void createAWithPersist() {
        A a = new A();
        aRepository.persist(a);
        assertThat(a.id).isNotNull();
        System.out.println(a);
    }

    @Test
    @Transactional
    void createAWithMerge() {
        A a = new A();
        a = aRepository.getEntityManager().merge(a);
        assertThat(a.id).isNotNull();
        System.out.println(a);
    }

    @Test
    @Transactional
    void persistCWithB() {
        B b = new B();
        C c1 = new C(b);
        C c2 = new C(b);
        C c3 = new C(b);
        C c4 = new C(b);

        //bRepository.persist(b);
        cRepository.persist(c1);
        cRepository.persist(c2);
        cRepository.persist(c3);
        cRepository.persist(c4);

        System.out.println(c1);
    }

    @Test
    void mergeCWithB() {
        B b = new B();
        C c1 = new C(b);
        C c2 = new C(b);
        C c3 = new C(b);
        C c4 = new C(b);

        //bRepository.persist(b);
        cRepository.save(c1);
        cRepository.save(c2);
        cRepository.save(c3);
        cRepository.save(c4);

        System.out.println(c1);
    }




    @Test
    @Transactional
    void persistCWithBAndA() {
        A a = new A();
        B b = new B();
        C c = new C();
        c.b = b;
        b.a = a;

        //bRepository.persist(b);
        cRepository.persist(c);

        System.out.println(c);
    }
}