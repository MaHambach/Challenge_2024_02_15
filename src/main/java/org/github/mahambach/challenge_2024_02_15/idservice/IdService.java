package org.github.mahambach.challenge_2024_02_15.idservice;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdService {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
