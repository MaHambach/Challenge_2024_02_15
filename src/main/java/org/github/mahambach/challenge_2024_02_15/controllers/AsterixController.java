package org.github.mahambach.challenge_2024_02_15.controllers;

import lombok.RequiredArgsConstructor;
import org.github.mahambach.challenge_2024_02_15.AsterixCharacter;
import org.github.mahambach.challenge_2024_02_15.AsterixRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {
    private final AsterixRepo repo;
    @GetMapping
    public List<AsterixCharacter> getAsterix() {
        return repo.findAll();
    }
//    @GetMapping("/search")
//    public List<AsterixCharacter> getAsterixCharacterByName(@RequestParam String name) {
//        return repo.findAll().stream().filter(c->c.name().equals(name)).collect(Collectors.toList());
//    }

    @PostMapping
    public AsterixCharacter addAsterixCharacter(@RequestBody AsterixCharacter character) {
        repo.save(character);
        return character;
    }

    @PostMapping("/bulk")
    public List<AsterixCharacter> addAsterixCharacters(@RequestBody List<AsterixCharacter> characters) {
        repo.saveAll(characters);
        return characters;
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

    @GetMapping("/search")
    public List<AsterixCharacter> searchAsterixCharacters(@RequestParam(required = false) String id,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String occupation,
                                                          @RequestParam(required = false) int age){
        return this.repo.findAll()
                .stream()
                .filter(character -> character.id().equals(id) ||
                        character.name().equals(name) ||
                        character.occupation().equals(occupation) ||
                        character.age() == age)
                .toList();
    }

    @GetMapping("/search/partial")
    public List<AsterixCharacter> partialSearchAsterixCharacters(@RequestParam(required = false) String id,
                                                        @RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String occupation){
        String searchId = id == null ? "" : id;
        String searchName = name == null ? "" : name;
        String searchText = occupation == null ? "" : occupation;

        return this.repo.findAll()
                .stream()
                .filter(character -> character.id().contains(searchId) &&
                        character.name().contains(searchName)&&
                        character.occupation().contains(searchText))
                .toList();
    }

    @GetMapping("/average_age")
    public double averageAge() {
        return repo.findAll().stream().mapToInt(AsterixCharacter::age).average().orElse(0);
    }
}
