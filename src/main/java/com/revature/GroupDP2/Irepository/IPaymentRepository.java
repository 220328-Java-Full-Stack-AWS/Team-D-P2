package com.revature.GroupDP2.Irepository;

import java.util.List;

public interface IPaymentRepository<Payment> extends IGenericRepository<Payment>{

    Payment getPaymentByCardNumber(Payment payment);

}
