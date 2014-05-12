package org.jboss.tools.example.springmvc.repo;

import javax.persistence.EntityManager;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AmbulanceCall findByTeamId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(AmbulanceCall call) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
