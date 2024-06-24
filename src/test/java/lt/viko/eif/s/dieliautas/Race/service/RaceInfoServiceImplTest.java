package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import lt.viko.eif.s.dieliautas.Race.repository.RaceInfoRepository;
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
 * Testuoja RaceInfoServiceImpl klasės metodus.
 */
public class RaceInfoServiceImplTest {

    @Mock
    private RaceInfoRepository raceInfoRepository;

    @InjectMocks
    private RaceInfoServiceImpl raceInfoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testuoja getAllRaceInfos metodą.
     */
    @Test
    public void testGetAllRaceInfos() {
        RaceInfo raceInfo1 = new RaceInfo();
        raceInfo1.setId(1);

        RaceInfo raceInfo2 = new RaceInfo();
        raceInfo2.setId(2);

        List<RaceInfo> raceInfos = Arrays.asList(raceInfo1, raceInfo2);

        when(raceInfoRepository.findAll()).thenReturn(raceInfos);

        List<RaceInfo> result = raceInfoService.getAllRaceInfos();
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
    }
}
