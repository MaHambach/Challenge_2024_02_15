package org.github.mahambach.challenge_2024_02_15;

import org.springframework.data.annotation.Id;

public record AsterixCharacter(@Id String id, String name, int age, String occupation) {
}
