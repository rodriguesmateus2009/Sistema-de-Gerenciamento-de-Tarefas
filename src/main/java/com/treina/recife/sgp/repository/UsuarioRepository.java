package com.treina.recife.sgp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.treina.recife.sgp.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional <Usuario> findByEmail(String email);
    Optional <Usuario> findByCpf(String cpf);
    Optional <Usuario> findByCpfAndEmail(String cpf, String email);
    boolean existsByEmail(String email);
}
    