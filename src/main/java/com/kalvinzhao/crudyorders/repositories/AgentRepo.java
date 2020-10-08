package com.kalvinzhao.crudyorders.repositories;

import com.kalvinzhao.crudyorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepo extends CrudRepository<Agent, Long> {
}
