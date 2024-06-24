package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Racer;
import lt.viko.eif.s.dieliautas.Race.repository.RacerRepository;
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
 * Testuoja RacerServiceImpl klasės metodus.
 */
public class RacerServiceImplTest {

    @Mock
    private RacerRepository racerRepository;

    @InjectMocks
    private RacerServiceImpl racerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testuoja getAllRacers metodą.
     */
    @Test
    public void testGetAllRacers() {
        Racer racer1 = new Racer();
        racer1.setId(1);
        racer1.setFirstName("John");

        Racer racer2 = new Racer();
        racer2.setId(2);
        racer2.setFirstName("Jane");

        List<Racer> racers = Arrays.asList(racer1, racer2);

        when(racerRepository.findAll()).thenReturn(racers);

        List<Racer> result = racerService.getAllRacers();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());
    }
}
