package com.vargas.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== Buscando usuario: '" + username + "' ===");
        UserDetails usuario = repository.findByLogin(username);
        if (usuario == null) {
            System.out.println("=== USUARIO NO ENCONTRADO EN BD ===");
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }

}
