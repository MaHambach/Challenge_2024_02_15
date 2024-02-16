package org.github.mahambach.challenge_2024_02_15.services;

import lombok.RequiredArgsConstructor;
import org.github.mahambach.challenge_2024_02_15.data.AsterixCharacter;
import org.github.mahambach.challenge_2024_02_15.data.dto.AsterixCharacterNoIdDTO;
import org.github.mahambach.challenge_2024_02_15.idservice.IdService;
import org.github.mahambach.challenge_2024_02_15.repositories.AsterixRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AsterixService {
    private final AsterixRepo asterixRepo;
    private final IdService idService;

    public List<AsterixCharacter> findAll() {
        return asterixRepo.findAll();
    }

    public AsterixCharacter addAsterixCharacter(AsterixCharacterNoIdDTO characterNoIdDTO) {
        return asterixRepo.save(new AsterixCharacter(idService.generateId(), characterNoIdDTO.name(), characterNoIdDTO.age(), characterNoIdDTO.occupation()));
    }


    public List<AsterixCharacter> addAsterixCharacters(List<AsterixCharacterNoIdDTO> charactersNoIdDTO) {
        return asterixRepo.saveAll(charactersNoIdDTO.stream()
                .map(characterNoIdDTO -> new AsterixCharacter(idService.generateId(), characterNoIdDTO.name(), characterNoIdDTO.age(), characterNoIdDTO.occupation()))
                .toList());
    }

    public AsterixCharacter updateAsterixCharacter(String id, AsterixCharacterNoIdDTO characterNoIdDTO) {
        return asterixRepo.save(new AsterixCharacter(id, characterNoIdDTO.name(), characterNoIdDTO.age(), characterNoIdDTO.occupation()));
    }

    public String deleteById(String id) {
        asterixRepo.deleteById(id);
        return "Character with id " + id + " was removed.";
    }

    public List<AsterixCharacter> searchAsterixCharacters(String id, String name, String occupation, String age){
        Stream<AsterixCharacter> characters = this.asterixRepo.findAll().stream();

        if(id != null) {
            characters = characters.filter(character -> character.id().equalsIgnoreCase(id));
        }
        if(name != null) {
            characters = characters.filter(character -> character.name().equalsIgnoreCase(name));
        }
        if(occupation != null) {
            characters = characters.filter(character -> character.occupation().equalsIgnoreCase(occupation));
        }
        if(age != null) {
            characters = characters.filter(character -> String.valueOf(character.age()).equalsIgnoreCase(age));
        }
        return characters.toList();
    }

    public List<AsterixCharacter> partialSearchAsterixCharacters(String id, String name, String occupation, String age){
        return this.asterixRepo.findAll()
                .stream()
                .filter(character -> character.id().contains(id) &&
                        character.name().contains(name)&&
                        character.occupation().contains(occupation) &&
                        String.valueOf(character.age()).contains(age))
                .toList();
    }

    public double averageAge() {
        return asterixRepo.findAll().stream()
                .mapToInt(AsterixCharacter::age)
                .average().orElse(0);
    }

    public List<AsterixCharacter> searchAsterixCharactersWithMaxAge(String age) {
        return asterixRepo.findByAgeLessThanEqual(Integer.parseInt(age));
    }
}
