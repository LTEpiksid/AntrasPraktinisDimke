package lt.viko.eif.s.dieliautas.Race.repository;

import lt.viko.eif.s.dieliautas.Race.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * `StatusRepository` sąsaja išplečia `JpaRepository` ir suteikia pagrindines CRUD operacijas `Status` objektams.
 */
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
