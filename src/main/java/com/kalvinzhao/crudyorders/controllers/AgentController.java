package com.kalvinzhao.crudyorders.controllers;

import com.kalvinzhao.crudyorders.models.Agent;
import com.kalvinzhao.crudyorders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    AgentService agentServices;

//    http://localhost:2019/agents/agent/9
    @GetMapping(value = "/agent/{id}", produces = {"application/json"})
    public ResponseEntity<?> findByAgentId(@PathVariable long id) {
        Agent returnAgent = agentServices.findAgentById(id); // STEP 2, IMPLEMENT THIS IN SERVICE
        return new ResponseEntity<>(returnAgent, HttpStatus.OK);
    }
}
