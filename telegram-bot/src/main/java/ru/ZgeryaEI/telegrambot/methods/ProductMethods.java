package ru.ZgeryaEI.telegrambot.methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ZgeryaEI.telegrambot.model.Category;
import ru.ZgeryaEI.telegrambot.model.Product;
import ru.ZgeryaEI.telegrambot.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductMethods {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
    }


    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public Product createProduct(String name, String description, Double price, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return productRepository.save(product);
    }

}