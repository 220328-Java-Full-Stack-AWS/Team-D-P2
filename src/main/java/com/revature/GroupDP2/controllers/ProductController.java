package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        return productService.getAll();
    }

        //get product by productname
    @GetMapping("/{productnameorId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct (@PathVariable String productnameorId, @RequestHeader("mode") String mode) throws
    Exception {
    switch (mode) {
        case "productname":
            return productService.getProductByProductname(productnameorId);
        case "id":
            return productService.getProductById(Integer.parseInt(productnameorId));
        default:
            throw new Exception("That's not a valid mode");
            //TODO: Make this better
    }
    }

    //post a new product - auto generate the ID
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void persistNewProduct (@RequestBody Product newProduct){
        productService.createProduct(newProduct);
    }

    @GetMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public AuthDto authorizeProduct (@RequestBody AuthDto authDto) throws Exception {
    return productService.authenticateProduct(authDto);
    //TODO: ResponseEntity<User> use this object to send back a different response for unauthorized
    }

    //put (update) an existing user (based on id)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct (@RequestBody Product product){
    productService.update(product);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Product deleteProduct (@RequestBody Product product){
    return productService.delete(product);
    }

}


/*import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public abstract class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/product")
    public String listProduct(Model model) {
        model.addAttribute("product", productService.getAllProduct());
        return "product";
    }

    @GetMapping("/product/new")
    public String createProductForm(Model model) {

        // create student object to hold student form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "create_product";

    }

    @PostMapping("/product")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProductForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit_product";
    }

    @PostMapping("/product/{id}")
    public String updateProduct(@PathVariable Integer id,
                                @ModelAttribute("product") Product product,
                                Model model) {

        // get student from database by id
        Product existingProduct = (Product) ProductService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategoryId(product.getCategoryId());

        // save updated student object
        productService.updateProduct(existingProduct);
        return "redirect:/product";
    }

    // handler method to handle delete student request

    @GetMapping("/product/{id}")
    public String deleteProduct(@PathVariable Interger id) {
        productService.deleteProductById(id);
        return "redirect:/product";
    }

    public abstract List<Product> getAllProduct();

    public class Interger {
    }
}
*/

/*
protected class ProductServices {
        public List<Product> getAllProduct;

        public String getProductByProductname(String productnameorId) {
            return productnameorId;
        }

        public String getProductById(int parseInt) {
            return null;
        }

        public Product save(Object persistNewProduct) {
            return new Product();
        }

        public void update(Product product) {
            ;
        }

        public Product delete(Product product) {
            return product;
        }

        public AuthDto authenticateProduct(AuthDto authDto) {
            return authDto;
        }


    }
 */