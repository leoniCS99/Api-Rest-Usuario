package com.cadastro.usuario.repository;

import com.cadastro.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM Usuario WHERE Usuario = ?",nativeQuery = true)
    List<Usuario> findByUsuario (@PathVariable("usuario") String usuario);

    boolean existsByUsuario(String usuario);

    void deleteById (Long id);

}
