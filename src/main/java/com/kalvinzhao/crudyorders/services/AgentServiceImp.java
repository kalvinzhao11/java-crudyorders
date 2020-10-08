package com.kalvinzhao.crudyorders.services;

import com.kalvinzhao.crudyorders.models.Agent;
import com.kalvinzhao.crudyorders.repositories.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional //anytime if any method is transactional, make the whole class transactional
@Service(value = "agentServices")
public class AgentServiceImp implements AgentService{

    @Autowired
    AgentRepo agentrepos;

    @Override
    public Agent findAgentById(long id) {
        Agent returnAgent = agentrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + id + " Not Found"));
        return returnAgent;
    }

    @Transactional
    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }
}
