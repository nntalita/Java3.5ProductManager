package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {
    private Product product = new Product();
    private Product first = new Product(1111, "стол", 1000);
    private Book second = new Book(11112, "Синяя", 100, "Папа Карло");
    private Smartphone third = new Smartphone(3333, "Honor", 12000, "Huawei");
    private Smartphone fourth = new Smartphone(4444, "Samsung", 12000, "Samsung");
    private Book fifth = new Book(5512555, "Букварь", 190, "Папа Карло");


    @Test
    public void shouldProductMatchesSearchByName() {

        assertTrue(first.matches("стол"));
    }

    @Test
    public void shouldProductMatchesSearchByNameMissing() {

        assertFalse(first.matches("стул"));
    }

    @Test
    public void shoulBookMatchesSearchByName() {

        assertTrue(second.matches("Папа"));
    }

    @Test
    public void shouldBookMatchesSearchByNameMissing() {

        assertFalse(fifth.matches("Honor"));
    }

    @Test
    public void shoulSmartphoneMatchesSearchByName() {

        assertTrue(third.matches("Honor"));
    }

    @Test
    public void shouldSmartphoneMatchesSearchByNameMissing() {

        assertFalse(fourth.matches("Huawei"));
    }
}
