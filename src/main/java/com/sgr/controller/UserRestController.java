package com.sgr.controller;


import java.util.List;

import com.sgr.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.service.UserService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/api/users*/
    @GetMapping("/users")
    public List<Usuario> findAll(){
        //retornará todos los usuarios
        return userService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/users/1*/
    @GetMapping("/users/{userId}")
    public Usuario getUser(@PathVariable Long userId){
        Usuario usuario = userService.findById(userId);

        if(usuario == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        //retornará al usuario con id pasado en la url
        return usuario;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/users/  */
    @PostMapping("/users")
    public Usuario addUser(@RequestBody Usuario usuario) {

        //Este metodo guardará al usuario enviado
        userService.save(usuario);

        return usuario;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/users/  */
    @PutMapping("/users/{id}")
    public Usuario updateUser(@PathVariable("id") Long id, @RequestBody Usuario usuario) {


        userService.update(id, usuario);

        //este metodo actualizará al usuario enviado

        return usuario;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/users/1  */
    @DeleteMapping("users/{userId}")
    public String deteteUser(@PathVariable Long userId) {

        Usuario usuario = userService.findById(userId);

        if(usuario == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        userService.deleteById(userId);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted user id - "+userId;
    }

}