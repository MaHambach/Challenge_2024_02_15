package org.github.mahambach.challenge_2024_02_15.data.dto;

import lombok.With;
import org.springframework.data.annotation.Id;

public record AsterixCharacterNoIdDTO (String name, String age, String occupation){
}
