package app.e_commerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private Long id;
    private User user;
    private List<Product> listItens;
    //valorTotal
}
