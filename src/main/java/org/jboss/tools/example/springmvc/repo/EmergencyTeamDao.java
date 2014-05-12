package org.jboss.tools.example.springmvc.repo;

import java.util.List;
import org.jboss.tools.example.springmvc.domain.EmergencyTeam;

/**
 *
 * @author administrator
 */
public interface EmergencyTeamDao {
    
    EmergencyTeam findById(Long id);
    
    EmergencyTeam findByName(String name);
    
    List<EmergencyTeam> findAllOrderedByName();
    
    void register(EmergencyTeam team);
}
