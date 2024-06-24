package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import lt.viko.eif.s.dieliautas.Race.repository.RaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Testuoja RaceServiceImpl klasės metodus.
 */
public class RaceServiceImplTest {

    @Mock
    private RaceRepository raceRepository;

    @InjectMocks
    private RaceServiceImpl raceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testuoja getAllRaces metodą.
     */
    @Test
    public void testGetAllRaces() {
        Race race1 = new Race();
        race1.setId(1);
        race1.setName("Race1");

        Race race2 = new Race();
        race2.setId(2);
        race2.setName("Race2");

        List<Race> races = Arrays.asList(race1, race2);

        when(raceRepository.findAll()).thenReturn(races);

        List<Race> result = raceService.getAllRaces();
        assertEquals(2, result.size());
        assertEquals("Race1", result.get(0).getName());
        assertEquals("Race2", result.get(1).getName());
    }
}
