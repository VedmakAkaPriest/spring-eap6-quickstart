package org.jboss.tools.example.springmvc.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.jboss.tools.example.springmvc.domain.EmergencyTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author administrator
 */
@Repository
@Transactional
public class EmergencyTeamDaoImpl implements EmergencyTeamDao {
    
    @Autowired
    private EntityManager em;

    @Override
    public EmergencyTeam findById(Long id) {
        return em.find(EmergencyTeam.class, id);
    }

    @Override
    public EmergencyTeam findByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<EmergencyTeam> criteria = builder.createQuery(EmergencyTeam.class);
        Root<EmergencyTeam> team = criteria.from(EmergencyTeam.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(team).where(builder.equal(team.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<EmergencyTeam> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EmergencyTeam> criteria = cb.createQuery(EmergencyTeam.class);
        Root<EmergencyTeam> team = criteria.from(EmergencyTeam.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(team).orderBy(cb.asc(team.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public void register(EmergencyTeam team) {
        em.persist(team);
    }
    
}
