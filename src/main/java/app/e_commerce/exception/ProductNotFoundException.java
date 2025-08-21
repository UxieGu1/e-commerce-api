package app.e_commerce.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Produto com ID " + id + " não foi encontrado.");
    }
}
