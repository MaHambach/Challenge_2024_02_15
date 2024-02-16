package org.github.mahambach.challenge_2024_02_15.repositories;

import org.github.mahambach.challenge_2024_02_15.data.AsterixCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsterixRepo extends MongoRepository<AsterixCharacter, String>{
    List<AsterixCharacter> findByAgeLessThanEqual(int age);
}
