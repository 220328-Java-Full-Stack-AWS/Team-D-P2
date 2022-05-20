package com.revature.GroupDP2.Irepository;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.model.Product;

import java.util.List;

public interface ICartRepository extends IGenericRepository<Cart>{

    //NEED TO FINISH THIS METHOD
    List<Cart> getAll();
}
