package com.revature.GroupDP2;

import com.revature.GroupDP2.repository.CartRepository;
import com.revature.GroupDP2.services.CartService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestCartService {

    private CartService cartService;

    @Mock
    private CartRepository cartRepository;
}
