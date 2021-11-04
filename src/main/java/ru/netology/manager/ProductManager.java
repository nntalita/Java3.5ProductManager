package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private final ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        Product[] products = repository.findAll();
        if (text.equals("")) return result;
        for (Product product : products) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

    public Product searchById(int id) {

        Product product = repository.findById(id);
        return product;
    }

    public void deleteByid(int id) {
        Product product = repository.removeById(id);

    }

    public Product[] viewAll() {
        Product[] products = repository.findAll();
        return products;


    }
}