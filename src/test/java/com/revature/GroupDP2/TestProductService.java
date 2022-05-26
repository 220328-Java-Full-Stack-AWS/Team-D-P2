package com.revature.GroupDP2;

import com.revature.GroupDP2.repository.ProductRepository;
import com.revature.GroupDP2.services.ProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestProductService {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;
}
