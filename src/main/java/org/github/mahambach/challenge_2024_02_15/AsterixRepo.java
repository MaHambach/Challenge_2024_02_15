package org.github.mahambach.challenge_2024_02_15;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsterixRepo extends MongoRepository<AsterixCharacter, String>{
}
