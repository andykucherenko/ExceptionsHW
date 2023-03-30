import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    private ShopRepository repository;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    @BeforeEach
    public void setUp() {
        repository = new ShopRepository();
        product1 = new Product(1, "Book", 600);
        product2 = new Product(2, "T-shirt", 1200);
        product3 = new Product(3, "Notebook", 49999);
        product4 = new Product(4, "TV-set", 29999);
        product5 = new Product(5, "Snickers", 5990);
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
    }

    @Test
    void shouldRemoveById() {
        repository.remove(3);
        Product[] expected = new Product[]{product1, product2, product4, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

        repository.remove(5);
        expected = new Product[]{product1, product2, product4};
        actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(6));
        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(-1));
    }
}

