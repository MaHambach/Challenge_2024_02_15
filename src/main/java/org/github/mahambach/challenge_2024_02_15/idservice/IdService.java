package org.github.mahambach.challenge_2024_02_15.idservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IdService {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
