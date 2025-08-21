package app.e_commerce.controller;

import app.e_commerce.entity.Product;
import app.e_commerce.exception.ProductNotFoundException;
import app.e_commerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Endpoint de Listar
    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll(){
        try{
            List<Product> products = productService.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    //Endpoint de ListarPorId
    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
        try{
            Optional<Product> productById = productService.findById(id);
            return new ResponseEntity<>(productById, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    //EndPoint de Criar
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        try{
            Product productCreated = productService.create(product);
            return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    //Endpoint de Atualizar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
        try{
            Product updatedProduct = productService.update(id, product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    //Endpoint de Deletar
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            Optional<Product> product = productService.findById(id);
            productService.deleteById(id);
            return new ResponseEntity<>("Produto deletado com sucesso!", HttpStatus.OK);

        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>("Produto com ID " + id + " não encontrado.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar produto.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
