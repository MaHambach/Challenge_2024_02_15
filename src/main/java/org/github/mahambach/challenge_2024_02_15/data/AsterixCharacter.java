package org.github.mahambach.challenge_2024_02_15.data;

import lombok.With;
import org.springframework.data.annotation.Id;

@With
public record AsterixCharacter(@Id String id, String name, String age, String occupation) {
}
