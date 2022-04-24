package com.cadastro.usuario.services;

import com.cadastro.usuario.Dto.UsuarioDto;
import com.cadastro.usuario.model.Usuario;
import com.cadastro.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    final private UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;


    public void salvarUsuario(UsuarioDto usuarioDto){

        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuarioRepository.save(usuario);
    }

    public List<Usuario> BuscarUsuario(String usuario){
      List<Usuario> usuarioList =  usuarioRepository.findByUsuario(usuario);
      return usuarioList;
    }

   public boolean existsByUsuario(String usuario){
       return usuarioRepository.existsByUsuario(usuario);
   }

   public void deletarUsuario(Long usuario){
        usuarioRepository.deleteById(usuario);
   }
}
