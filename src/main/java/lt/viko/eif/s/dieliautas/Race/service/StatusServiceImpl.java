package lt.viko.eif.s.dieliautas.Race.service;

import lt.viko.eif.s.dieliautas.Race.model.Status;
import lt.viko.eif.s.dieliautas.Race.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Statuso paslaugų įgyvendinimas.
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    /**
     * Grąžina visų statusų sąrašą.
     *
     * @return sąrašas su visais statusais
     */
    @Override
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}
