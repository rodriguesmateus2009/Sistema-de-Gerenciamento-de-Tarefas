package com.treina.recife.sgp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.treina.recife.sgp.constants.StatusUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @NotNull(message = "O nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "O CPF é obrigatório")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @NotNull(message = "O email é obrigatório")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "A senha é obrigatória")
    @Column(name = "senha", nullable = false)
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull(message = "O status é obrigatório")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @OneToMany(mappedBy = "responsavel")
    private List<Projeto> projetos = new ArrayList<>();
}
