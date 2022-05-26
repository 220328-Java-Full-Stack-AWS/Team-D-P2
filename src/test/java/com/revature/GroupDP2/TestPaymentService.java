package com.revature.GroupDP2;

import com.revature.GroupDP2.repository.PaymentRepository;
import com.revature.GroupDP2.services.PaymentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestPaymentService {

    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;
}
