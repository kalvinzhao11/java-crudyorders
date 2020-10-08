package com.kalvinzhao.crudyorders.services;

import com.kalvinzhao.crudyorders.models.Agent;

public interface AgentService {
    Agent save(Agent agent);

    Agent findAgentById(long id);
}
