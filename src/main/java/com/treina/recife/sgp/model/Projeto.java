package com.treina.recife.sgp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.treina.recife.sgp.constants.StatusProjeto;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projetos")
    public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;

    @NotNull(message = "O nome é obrigatório")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "A descrição é obrigatória")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de início é obrigatória")
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de conclusão é obrigatória")
    @Column(name = "data_conclusao", nullable = false)
    private LocalDate dataConclusao;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Usuario responsavel;

    @NotNull(message = "O status é obrigatório")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

}
