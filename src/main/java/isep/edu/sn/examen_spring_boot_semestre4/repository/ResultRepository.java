package isep.edu.sn.examen_spring_boot_semestre4.repository;

import javax.xml.transform.Result;
import java.util.List;
public interface ResultRepository {
    List<Result> findAll();
}
