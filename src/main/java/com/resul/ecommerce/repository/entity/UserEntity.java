package com.resul.ecommerce.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    @NotBlank(message = "Username cannot be blank.")
    private String username;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Email cannot be blank.")
    private String email;
    
    @NotBlank(message = "Password cannot be blank.")
    private String password;

    public abstract UserTypeEnum getUserType();
}
