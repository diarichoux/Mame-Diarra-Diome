package isep.edu.sn.examen_spring_boot_semestre4.services;

import isep.edu.sn.examen_spring_boot_semestre4.repository.ResultRepository;
public class ResultServiceBuilder {
    private ResultRepository resultRepository;
    public ResultServiceBuilder setResultRepository(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
        return this;
    }
    public ResultService createResultService() {
        return new ResultService(resultRepository);
    }
}