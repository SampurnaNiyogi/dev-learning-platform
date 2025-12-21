package com.sampurna.UserManagementAPI.controller;

import com.sampurna.UserManagementAPI.dto.CreateProblemRequest;
import com.sampurna.UserManagementAPI.dto.ProblemResponse;
import com.sampurna.UserManagementAPI.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProblemController {
    private final ProblemService problemService;
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/problems")
    public List<ProblemResponse> getProblems(){
        return problemService.getAllProblems();
    }

    @GetMapping("/problems/{id}")
    public ProblemResponse getProblemById(@PathVariable Long id){
        return problemService.getProblemById(id);
    }

    @PostMapping("/problems")
    @ResponseStatus(HttpStatus.CREATED)
    public ProblemResponse createProblem(@Valid @RequestBody CreateProblemRequest req){
        return problemService.createProblem(req);
    }
}
