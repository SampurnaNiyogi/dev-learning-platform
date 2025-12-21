package com.sampurna.UserManagementAPI.exception;

public class ProblemNotFoundException extends RuntimeException {
    public ProblemNotFoundException(Long id) {
      super("Problem not found with id: " + id);
    }
}
