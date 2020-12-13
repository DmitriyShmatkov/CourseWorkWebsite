package com.coursework.freelance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Pattern(regexp = "[А-Я][а-я]*", message = "Имя указано некорректно")
    private String firstName;

    @Pattern(regexp = "[А-Я][а-я]*", message = "Фамилия указана некорректно")
    private String secondName;

    @Email(message = "Некорретный адрес эл. почты")
    private String email;

    @Pattern(regexp = "\\([0-9]{3}\\)-[0-9]{3}-[0-9]{2}-[0-9]{2}", message = "Некорретный формат номера телефона")
    private String phoneNumber;

    @NotBlank(message = "Некорретный формат логина")
    private String login;

    @NotBlank(message = "Некорретный формат пароля")
    private String password;

    private String photoURL;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
