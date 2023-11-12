package isep.edu.sn.examen_spring_boot_semestre4.services;
import isep.edu.sn.examen_spring_boot_semestre4.repository.ResultRepository;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
@Service
public class ResultService {
    /**
     *
     */
    private final ResultRepository resultRepository;
    public ResultService() {
        this(null);
    }
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }
    public List<Result> getResults() {
        return resultRepository.findAll();
    }
}
