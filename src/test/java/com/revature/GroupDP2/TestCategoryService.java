package com.revature.GroupDP2;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.repository.CategoryRepository;
import com.revature.GroupDP2.services.CategoryService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestCategoryService {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeAll
    public static void initializeTestSuite() {

    }

    @AfterAll
    public static void tearDownTestSuite() {

    }

    @BeforeEach
    public void initializeTest() {
        categoryService = new CategoryService(categoryRepository);
    }

    @AfterEach
    public void tearDownTest() {
        categoryService = null;
    }

    @Test
    void test_(){

    }

}


    // Still need to check for exceptions being thrown.
    // Still need to check negative outcomes,
    // still need to use "verify"
    // TDD?
