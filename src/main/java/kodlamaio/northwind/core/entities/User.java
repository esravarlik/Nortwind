package kodlamaio.northwind.core.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="id")
    private int id;

    @Column(name="email")
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Column(name="password")
    @NotNull
    @NotBlank
    private String password;
}
