package org.jboss.tools.example.springmvc.repo;

import org.jboss.tools.example.springmvc.domain.AmbulanceCall;

/**
 *
 * @author administrator
 */
public interface AmbulanceCallDao {

    AmbulanceCall findById(Long id);
    
    AmbulanceCall findByTeamId(Long id);
    
    void create(AmbulanceCall call);
    
}
