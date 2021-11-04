package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());
    private Product first = new Product(1111, "стол", 1000);
    private Book second = new Book(11112, "Синяя", 100, "Папа Карло");
    private Smartphone third = new Smartphone(3333, "Honor", 12000, "Huawei");
    private Smartphone fourth = new Smartphone(4444, "Samsung", 12000, "Samsung");
    private Book fifth = new Book(5512555, "Букварь", 190, "Папа Карло");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldSearchEmpty() {
        Product[] actual = manager.searchBy("");
        Product[] expected = {};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByNameProduct() {
        Product[] actual = manager.searchBy("стол");
        Product[] expected = {first};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByNameAndMadeBy() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {fourth};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] actual = manager.searchBy("Синяя");
        Product[] expected = {second};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {third};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByAutor() {
        Product[] actual = manager.searchBy("Папа Карло");
        Product[] expected = {second, fifth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByPart() {
        Product[] actual = manager.searchBy("о");
        Product[] expected = {first, second, fifth};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchByMadeBy() {
        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = {third};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNoText() {
        Product[] actual = manager.searchBy("Cat");
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchById() {
        Product actual = manager.searchById(1111);
        Product expected = first;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldSearchByMissingId() {
        Product actual = manager.searchById(11);
        Product expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldDeleteById() {
        manager.deleteByid(1111);
        Product[] actual = manager.viewAll();
        Product[] expected = {second, third, fourth, fifth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteByMissingId() {
        manager.deleteByid(1);
        Product[] actual = manager.viewAll();
        Product[] expected = {first, second, third, fourth, fifth};
        assertArrayEquals(actual, expected);
    }
}