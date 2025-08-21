package app.e_commerce.DTO;

import app.e_commerce.entity.enums.Roles;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;
    private Roles role;
}


