package br.com.topicosnewm.petshop.dataprovider.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario_contas")
@Data
public class UsuarioConta implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf_cnpj", unique = true)
    @NotBlank
    @Pattern(regexp = "(\\d{11})|(\\d{14})", message = "CPF ou CNPJ inválido")
    private String cpfCnpj;

    @Email(message = "Formato do e-mail está incorreto")
    @Column(name = "email")
    private String email;

    @Column(name = "login", unique = true)
    @NotBlank
    private String login;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "tag_plano")
    private Byte tagPlano;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @Column(name = "dt_expiracao")
    private LocalDateTime dtExpiracao;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.SUPER_ADMIN) {
            return List.of(new SimpleGrantedAuthority("SUPER_ADMIN")
                    ,new SimpleGrantedAuthority("ADMIN")
                    , new SimpleGrantedAuthority("USER"));
        }else if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ADMIN")
                    , new SimpleGrantedAuthority("USER"));
        } else {
            return  List.of(new SimpleGrantedAuthority("USER"));
        }
    }

    @Override
    public String getUsername() {
        return login;
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
