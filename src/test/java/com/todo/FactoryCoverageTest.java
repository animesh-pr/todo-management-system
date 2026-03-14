package com.todo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.todo.factory.RepositoryFactory;

class FactoryCoverageTest {

    @Test
    void testAllFactoryBranches() {

        assertNotNull(RepositoryFactory.createRepository(1));
        assertNotNull(RepositoryFactory.createRepository(2));
        assertNotNull(RepositoryFactory.createRepository(3));

        assertThrows(IllegalArgumentException.class,
                () -> RepositoryFactory.createRepository(99));
    }
}