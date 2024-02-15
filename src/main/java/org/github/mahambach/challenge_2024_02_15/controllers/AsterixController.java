package org.github.mahambach.challenge_2024_02_15.controllers;

import lombok.RequiredArgsConstructor;
import org.github.mahambach.challenge_2024_02_15.AsterixCharacter;
import org.github.mahambach.challenge_2024_02_15.AsterixRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {
    private final AsterixRepo repo;
    @GetMapping
    public List<AsterixCharacter> getAsterix() {
        return repo.findAll();
    }

    @PostMapping
    public AsterixCharacter addAsterixCharacter(@RequestBody AsterixCharacter character) {
        repo.save(character);
        return character;
    }

    @PutMapping("/{id}")
    public AsterixCharacter updateAsterixCharacter(@PathVariable String id, @RequestBody AsterixCharacter character) {
        character = character.withId(id);
        repo.save(character);
        return character;
    }

    @DeleteMapping("/{id}")
    public String deleteAsterixCharacter(@PathVariable String id) {
        repo.deleteById(id);
        return "Character with id " + id + " was removed.";
    }
}
