package org.github.mahambach.challenge_2024_02_15.controllers;

import lombok.RequiredArgsConstructor;
import org.github.mahambach.challenge_2024_02_15.data.AsterixCharacter;
import org.github.mahambach.challenge_2024_02_15.data.dto.AsterixCharacterNoIdDTO;
import org.github.mahambach.challenge_2024_02_15.services.AsterixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {
    private final AsterixService asterixService;
    @GetMapping
    public List<AsterixCharacter> getAsterix() {
        return asterixService.findAllCharacters();
    }

    @GetMapping("/{id}")
    public AsterixCharacter getAsterixCharacterById(@PathVariable String id) {
        return asterixService.findById(id);
    }

    @PostMapping
    public AsterixCharacter addAsterixCharacter(@RequestBody AsterixCharacterNoIdDTO characterNoIdDTO) {
        return asterixService.addAsterixCharacter(characterNoIdDTO);
    }

    @PostMapping("/bulk")
    public List<AsterixCharacter> addAsterixCharacters(@RequestBody List<AsterixCharacterNoIdDTO> charactersNoIdDTO) {
        return asterixService.addAsterixCharacters(charactersNoIdDTO);
    }

    @PutMapping("/{id}")
    public AsterixCharacter updateAsterixCharacter(@PathVariable String id, @RequestBody AsterixCharacterNoIdDTO characterNoIdDTO) {
        return asterixService.updateAsterixCharacter(id, characterNoIdDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteAsterixCharacter(@PathVariable String id) {
        return this.asterixService.deleteById(id);
    }

    @GetMapping("/search")
    public List<AsterixCharacter> searchAsterixCharacters(@RequestParam(required = false) String id,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String age,
                                                          @RequestParam(required = false) String occupation) {
        return this.asterixService.searchAsterixCharacters(id, name, occupation, age);
    }

    @GetMapping("/search/{age}")
    public List<AsterixCharacter> findAsterixCharactersWithMaxAge(@PathVariable String age){
        return this.asterixService.searchAsterixCharactersWithMaxAge(age);
    }

    @GetMapping("/search/partial")
    public List<AsterixCharacter> partialSearchAsterixCharacters(@RequestParam(required = false) String id,
                                                                 @RequestParam(required = false) String name,
                                                                 @RequestParam(required = false) String occupation,
                                                                 @RequestParam(required = false) String age){
        return this.asterixService.partialSearchAsterixCharacters(id, name, occupation, age);
    }

    @GetMapping("/average_age")
    public double averageAge() {
        return asterixService.averageAge();
    }
}
