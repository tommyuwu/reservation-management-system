package com.sgr.service;

import com.sgr.dao.UserDAO;
import com.sgr.entity.Usuario;
import lombok.AllArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<Usuario> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public String save(Usuario usuario){
    	String resultado = validarCampos(usuario);
    	if(resultado.equals("ok")) {
    		System.out.println("usuario a crear: "+usuario.toString());
            resultado = userDAO.save(usuario);
    	}    	
        return resultado;
    }

    private String validarCampos(Usuario usuario) {
    	String resultado = "ok";
		if(StringUtils.isBlank(usuario.getPassword()))
			resultado = "Contraseña vacía, favor complete el campo";
		
		if(StringUtils.isBlank(usuario.getRol()))
			resultado =  "Rol vacío, favor complete el campo";
		
		if(StringUtils.isBlank(usuario.getUsername()))
			resultado = "Nombre de usuario vacío, favor complete el campo";
		return resultado;
	}

	@Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void update(Long id, Usuario usuario) {
        userDAO.update(id, usuario);
    }
}