package org.jboss.tools.example.springmvc.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.jboss.tools.example.springmvc.domain.AmbulanceCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author administrator
 */
@Repository
@Transactional
public class AmbulanceCallDaoImpl implements AmbulanceCallDao {

    @Autowired
    private EntityManager em;
    
    @Override
    public AmbulanceCall findById(Long id) {
        return em.find(AmbulanceCall.class, id);
    }

    @Override
    public AmbulanceCall findByTeamId(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AmbulanceCall> criteria = builder.createQuery(AmbulanceCall.class);
        Root<AmbulanceCall> call = criteria.from(AmbulanceCall.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(call).where(builder.equal(call.get("teamId"), id));
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<AmbulanceCall> findAllByStatus(String status) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AmbulanceCall> criteria = builder.createQuery(AmbulanceCall.class);
        Root<AmbulanceCall> call = criteria.from(AmbulanceCall.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(call).where(builder.equal(call.get("status"), status));
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public List<AmbulanceCall> findAllInProgressOrderedByStatus() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AmbulanceCall> criteria = builder.createQuery(AmbulanceCall.class);
        Root<AmbulanceCall> call = criteria.from(AmbulanceCall.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(call).where(builder.notEqual(call.get("status"), "completed"));
        return em.createQuery(criteria).getResultList();
    }
    
    @Override
    public void create(AmbulanceCall call) {
        em.persist(call);
    }

}
