package app.e_commerce.entity;

import app.e_commerce.entity.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private User user;
    //itens comprados,
    private Status status;
    //valor total
}
