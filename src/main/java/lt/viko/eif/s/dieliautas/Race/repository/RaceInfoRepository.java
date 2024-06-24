package lt.viko.eif.s.dieliautas.Race.repository;

import lt.viko.eif.s.dieliautas.Race.model.RaceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * `RaceInfoRepository` sąsaja išplečia `JpaRepository` ir suteikia pagrindines CRUD operacijas `RaceInfo` objektams.
 */
public interface RaceInfoRepository extends JpaRepository<RaceInfo, Integer> {
}
