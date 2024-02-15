package org.github.mahambach.challenge_2024_02_15.controllers;

import org.github.mahambach.challenge_2024_02_15.AsterixCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix")
public class AsterixController {
    @GetMapping("/characters")
    public List<AsterixCharacter> getAsterix() {
        return List.of(
                new AsterixCharacter("1", "Asterix", 35, "Krieger"),
                new AsterixCharacter("2", "Obelix", 35, "Lieferant"),
                new AsterixCharacter("3", "Miraculix", 60, "Druide"),
                new AsterixCharacter("4", "Majestix", 60, "Häuptling"),
                new AsterixCharacter("5", "Troubadix", 25, "Barden"),
                new AsterixCharacter("6", "Gutemine", 35, "Häuptlingsfrau"),
                new AsterixCharacter("7", "Idefix", 5, "Hund"),
                new AsterixCharacter("8", "Geriatrix", 70, "Rentner"),
                new AsterixCharacter("9", "Automatix", 35, "Schmied"),
                new AsterixCharacter("10", "Grockelix", 35, "Fischer")
        );
    }
}
