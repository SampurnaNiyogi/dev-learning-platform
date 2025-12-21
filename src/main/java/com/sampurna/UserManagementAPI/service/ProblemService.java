package com.sampurna.UserManagementAPI.service;

import com.sampurna.UserManagementAPI.dto.CreateProblemRequest;
import com.sampurna.UserManagementAPI.dto.ProblemResponse;
import com.sampurna.UserManagementAPI.exception.ProblemNotFoundException;
import com.sampurna.UserManagementAPI.model.Problem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProblemService {
    private Long id = 0L;
    private final HashMap<Long, Problem> problems = new HashMap<>();

    public ProblemResponse createProblem(CreateProblemRequest createProblemRequest) {
        id++;
        Problem problem = new Problem(id, createProblemRequest.getTitle(), createProblemRequest.getDescription(), createProblemRequest.getDifficulty());
        problems.put(id ,problem);
        return new ProblemResponse(id, createProblemRequest.getTitle(), createProblemRequest.getDescription(), createProblemRequest.getDifficulty());
    }

    public List<ProblemResponse> getAllProblems() {
        List<ProblemResponse> problemList = new ArrayList<>();
        for (Problem problem: problems.values()){
            problemList.add(new ProblemResponse(problem.getId(), problem.getTitle(), problem.getDescription(), problem.getDifficulty()));
        }
        return problemList;
    }

    public ProblemResponse getProblemById(Long id) {
        if (problems.containsKey(id)){
            Problem problem = problems.get(id);
            return new ProblemResponse(id, problem.getTitle(), problem.getDescription(), problem.getDifficulty());
        }
        throw new ProblemNotFoundException(id);
    }
}
