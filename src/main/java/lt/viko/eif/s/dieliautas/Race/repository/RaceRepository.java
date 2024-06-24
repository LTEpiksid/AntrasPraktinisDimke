package lt.viko.eif.s.dieliautas.Race.repository;

import lt.viko.eif.s.dieliautas.Race.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * `RaceRepository` sąsaja išplečia `JpaRepository` ir suteikia pagrindines CRUD operacijas `Race` objektams.
 */
public interface RaceRepository extends JpaRepository<Race, Integer> {
}
