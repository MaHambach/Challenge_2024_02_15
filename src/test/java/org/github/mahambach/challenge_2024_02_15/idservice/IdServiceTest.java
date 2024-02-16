package org.github.mahambach.challenge_2024_02_15.idservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({IdService.class})
class IdServiceTest {

    @Test
    void testGenerateId() {
        // Given
        mockStatic(UUID.class);
        UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        String expected = uuid.toString();
        when(UUID.randomUUID()).thenReturn(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        // When
        IdService idService = new IdService();
        String id = idService.generateId();

        // Then
        assertEquals(expected, id);
        verifyStatic(UUID.class, times(1));
    }
}