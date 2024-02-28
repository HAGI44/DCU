package artifact.repository;

import artifact.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public Optional<User> findByUid(String uid) {
        List<User> results = em.createQuery("select u from User u where u.uid = :uid", User.class)
                .setParameter("uid", uid)
                .getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByName(String name) {
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }
}
