package br.com.arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.arq.dto.UsersDto;
import br.com.arq.service.UsersService;

@ResponseBody
@RestController
@RequestMapping("/api/users")
public class UsersController {


    @Autowired
    private UsersService service;

    @PostMapping("/save")
    public ResponseEntity<?> saveUserController(@RequestBody UsersDto dto){
        try {
            return ResponseEntity.status(200).body(service.saveUsers(dto));
        }catch(Exception ex) {
            return ResponseEntity.status(500).body("error:" + ex.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUserController(@RequestBody UsersDto dto){
        try {
            return ResponseEntity.status(200).body(service.loginUsers(dto));

        }catch(Exception ex) {
            return ResponseEntity.status(500).body("error:" + ex.getMessage());
        }

    }


}

