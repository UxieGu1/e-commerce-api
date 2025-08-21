package app.e_commerce.service;

import app.e_commerce.entity.Product;
import app.e_commerce.exception.ProductNotFoundException;
import app.e_commerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Listar
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    //ListarPorId
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
    //Criar
    public Product create(Product product){
        return productRepository.save(product);
    }
    //Atualizar
    public Product update(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());
        return productRepository.save(existing);
    }
    //Deletar
    public void deleteById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.delete(product);
    }

}
