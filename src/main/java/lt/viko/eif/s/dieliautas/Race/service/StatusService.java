package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Status;

import java.util.List;

/**
 * Statuso paslaugų sąsaja.
 */
public interface StatusService {

    /**
     * Grąžina visų statusų sąrašą.
     *
     * @return sąrašas su visais statusais
     */
    List<Status> getAllStatuses();
}
