package org.jboss.tools.example.springmvc.repo;

import java.util.List;
import org.jboss.tools.example.springmvc.domain.AmbulanceCall;

/**
 *
 * @author administrator
 */
public interface AmbulanceCallDao {

    AmbulanceCall findById(Long id);
    
    AmbulanceCall findByTeamId(Long id);
    
    List<AmbulanceCall>findAllByStatus(String status);
    
    List<AmbulanceCall>findAllInProgressOrderedByStatus();
    
    void create(AmbulanceCall call);
    
}
