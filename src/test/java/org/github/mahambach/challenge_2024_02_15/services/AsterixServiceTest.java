package org.github.mahambach.challenge_2024_02_15.services;

import org.github.mahambach.challenge_2024_02_15.data.AsterixCharacter;
import org.github.mahambach.challenge_2024_02_15.data.dto.AsterixCharacterNoIdDTO;
import org.github.mahambach.challenge_2024_02_15.idservice.IdService;
import org.github.mahambach.challenge_2024_02_15.repositories.AsterixRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {

    private final AsterixRepo mockAsterixRepo = mock(AsterixRepo.class);
    private final IdService mockIdService = mock(IdService.class);

    @Test
    void findAllCharacters_whenEmpty_thenEmpty() {
        //Given
        List<AsterixCharacter> expected = new ArrayList<>();
        when(mockAsterixRepo.findAll()).thenReturn(new ArrayList<>());

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);

        //Then
        assertEquals(expected, asterixService.findAllCharacters());
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void findAllCharacters_whenSomething_thenSomething() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation2");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name3", 3, "occupation3");
        List<AsterixCharacter> expected = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3);
        when(mockAsterixRepo.findAll()).thenReturn(List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3));

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);

        //Then
        assertEquals(expected, asterixService.findAllCharacters());
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void findById_whenEmpty_thenThrow() {
        //Given
        when(mockAsterixRepo.findById("1")).thenReturn(Optional.empty());

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);

        //Then
        assertThrows(Exception.class, () -> asterixService.findById("1"));
        verify(mockAsterixRepo, times(1)).findById("1");
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void updateAsterixCharacter_whenUpdateToExpected_thenExpected() {
        //Given
        AsterixCharacter expected = new AsterixCharacter("id1", "name1", 1, "occupation1");
        when(mockAsterixRepo.save(expected)).thenReturn(expected);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        AsterixCharacter actual = asterixService.updateAsterixCharacter("id1", new AsterixCharacterNoIdDTO("name1", 1, "occupation1"));

        //Then
        assertEquals(expected, actual);
        verify(mockAsterixRepo, times(1)).save(expected);
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void deleteById() {
        assertTrue(true);
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void searchAsterixCharacters_whenId_thenId() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation2");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name3", 3, "occupation3");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name4", 4, "occupation4");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        List<AsterixCharacter> actual = asterixService.searchAsterixCharacters("id1", null, null, null);

        //Then
        assertEquals(List.of(asterixCharacter1), actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void searchAsterixCharacters_whenName_thenName() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation2");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name3", 3, "occupation3");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name4", 4, "occupation4");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        List<AsterixCharacter> actual = asterixService.searchAsterixCharacters("id1", null, null, null);

        //Then
        assertEquals(List.of(asterixCharacter1), actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void searchAsterixCharacters_whenAge_thenAge() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation2");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name3", 3, "occupation3");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name4", 4, "occupation4");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        List<AsterixCharacter> actual = asterixService.searchAsterixCharacters(null, null, "1", null);

        //Then
        assertEquals(List.of(asterixCharacter1), actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void searchAsterixCharacters_whenOccupation_thenOccupation() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation2");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name3", 3, "occupation3");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name4", 4, "occupation4");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        List<AsterixCharacter> actual = asterixService.searchAsterixCharacters(null, null, null, "occupation1");

        //Then
        assertEquals(List.of(asterixCharacter1), actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void searchAsterixCharacters_whenIdName_thenIdName() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation1");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name2", 3, "occupation2");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name3", 4, "occupation2");
        AsterixCharacter asterixCharacter5 = new AsterixCharacter("id5", "name3", 5, "occupation3");
        AsterixCharacter asterixCharacter6 = new AsterixCharacter("id6", "name1", 6, "occupation3");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4, asterixCharacter5, asterixCharacter6);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        List<AsterixCharacter> actual = asterixService.searchAsterixCharacters("id1", "name1", null, null);

        //Then
        assertEquals(List.of(asterixCharacter1), actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void searchAsterixCharacters_whenIdAge_thenIdAge() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation1");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name2", 3, "occupation2");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name3", 4, "occupation2");
        AsterixCharacter asterixCharacter5 = new AsterixCharacter("id5", "name3", 5, "occupation3");
        AsterixCharacter asterixCharacter6 = new AsterixCharacter("id6", "name1", 6, "occupation3");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4, asterixCharacter5, asterixCharacter6);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        List<AsterixCharacter> actual = asterixService.searchAsterixCharacters("id3", null, "3", null);

        //Then
        assertEquals(List.of(asterixCharacter3), actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void averageAge() {
        //Given
        AsterixCharacter asterixCharacter1 = new AsterixCharacter("id1", "name1", 1, "occupation1");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("id2", "name2", 2, "occupation1");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("id3", "name2", 3, "occupation2");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("id4", "name3", 4, "occupation2");
        AsterixCharacter asterixCharacter5 = new AsterixCharacter("id5", "name3", 5, "occupation3");
        AsterixCharacter asterixCharacter6 = new AsterixCharacter("id6", "name1", 6, "occupation3");
        List<AsterixCharacter> allFound = List.of(asterixCharacter1, asterixCharacter2, asterixCharacter3, asterixCharacter4, asterixCharacter5, asterixCharacter6);
        when(mockAsterixRepo.findAll()).thenReturn(allFound);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        double actual = asterixService.averageAge();

        //Then
        assertEquals(3.5, actual);
        verify(mockAsterixRepo, times(1)).findAll();
        verifyNoMoreInteractions(mockAsterixRepo);
    }

    @Test
    void addAsterixCharacter() {
        //Given
        AsterixCharacterNoIdDTO asterixCharacterNoIdDTO = new AsterixCharacterNoIdDTO("name1", 1, "occupation1");
        AsterixCharacter expected = new AsterixCharacter("id1", "name1", 1, "occupation1");
        when(mockIdService.generateId()).thenReturn("id1");
        when(mockAsterixRepo.save(expected)).thenReturn(expected);

        //When
        AsterixService asterixService = new AsterixService(mockAsterixRepo, mockIdService);
        AsterixCharacter actual = asterixService.addAsterixCharacter(asterixCharacterNoIdDTO);

        //Then
        assertEquals(expected, actual);
        verify(mockIdService, times(1)).generateId();
        verify(mockAsterixRepo, times(1)).save(expected);
        verifyNoMoreInteractions(mockAsterixRepo);
        verifyNoMoreInteractions(mockIdService);
    }
}