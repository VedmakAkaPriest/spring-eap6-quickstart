package org.jboss.tools.example.springmvc.mvc;

import java.util.List;
import org.jboss.tools.example.springmvc.domain.AmbulanceCall;
import org.jboss.tools.example.springmvc.repo.AmbulanceCallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author administrator
 */
@Controller
@RequestMapping("/rest/calls")
public class AmbulanceCallRestController {
    @Autowired
    private AmbulanceCallDao callDao;
    
    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<AmbulanceCall> listAllInProgress()
    {
        return callDao.findAllInProgressOrderedByStatus();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody AmbulanceCall lookupCallById(@PathVariable("id") Long id)
    {
        return callDao.findById(id);
    }
    
    @RequestMapping(value="/team/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody AmbulanceCall lookupCallByTeamId(@PathVariable("id") Long id)
    {
        return callDao.findByTeamId(id);
    }
}
