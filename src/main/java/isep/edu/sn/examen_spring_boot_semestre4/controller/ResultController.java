package isep.edu.sn.examen_spring_boot_semestre4.controller;

import isep.edu.sn.examen_spring_boot_semestre4.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;

// ResultController.java
@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping

    public ResponseEntity<?> getResults() {
        List<Result> results = resultService.getResults();
        return ResponseEntity.ok(results);
    }
}
