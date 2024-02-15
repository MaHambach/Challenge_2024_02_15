package org.github.mahambach.challenge_2024_02_15.controllers;

import lombok.RequiredArgsConstructor;
import org.github.mahambach.challenge_2024_02_15.AsterixCharacter;
import org.github.mahambach.challenge_2024_02_15.AsterixRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
@RequiredArgsConstructor
public class AsterixController {
    private final AsterixRepo repo;
    @GetMapping("/characters")
    public List<AsterixCharacter> getAsterix() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public void addAsterix(@RequestBody AsterixCharacter character) {
        repo.save(character);
    }
}
