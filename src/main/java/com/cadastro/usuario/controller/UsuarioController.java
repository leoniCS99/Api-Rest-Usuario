package com.cadastro.usuario.controller;

import com.cadastro.usuario.Dto.UsuarioDto;
import com.cadastro.usuario.model.Usuario;
import com.cadastro.usuario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    final private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity salvarUsuario(@Valid @RequestBody UsuarioDto usuario){

        if (usuarioService.existsByUsuario(usuario.getUsuario())){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario já existe na base");

        }

        usuarioService.salvarUsuario(usuario);
       return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/buscar/{usuario}")
    public List<Usuario> buscarUsuario(@RequestBody @PathVariable String usuario){
        return usuarioService.BuscarUsuario(usuario);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarUsuario(@RequestParam long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario excluido!");

    }
}
