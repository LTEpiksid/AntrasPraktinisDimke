package lt.viko.eif.s.dieliautas.Race.repository;

import lt.viko.eif.s.dieliautas.Race.model.Racer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * `RacerRepository` sąsaja išplečia `JpaRepository` ir suteikia pagrindines CRUD operacijas `Racer` objektams.
 * Taip pat suteikia metodą rasti lenktynininkus pagal jų būseną.
 */
public interface RacerRepository extends JpaRepository<Racer, Integer> {
    /**
     * Randa visus lenktynininkus pagal nurodytą būsenos pavadinimą.
     *
     * @param statusName būsenos pavadinimas, pagal kurį bus ieškoma lenktynininkų
     * @return lenktynininkų sąrašas, atitinkantis nurodytą būseną
     */
    List<Racer> findByStatusStatusName(String statusName);
}
