package com.mobytestbackend.exception;

import javax.persistence.PersistenceException;

public class TechnologyNotFoundException extends PersistenceException {
    public TechnologyNotFoundException(String message) {
    }
}
