package com.treina.recife.sgp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.treina.recife.sgp.constants.StatusTarefa;
import com.treina.recife.sgp.constants.Prioridade;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tarefas")
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @NotNull(message = "O título é obrigatório")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotNull(message = "A data de criação é obrigatória")
    @Column(name = "data_criacao", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;

    @NotNull(message = "A data de conclusão é obrigatória")
    @Column(name = "data_conclusao", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConclusao;

    @NotNull(message = "A prioridade é obrigatória")
    @Column(name = "prioridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @NotNull(message = "O status é obrigatório")
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "projeto_id", referencedColumnName = "project_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Usuario usuario;

}
