package br.com.arq.service;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class CriptografiaService {

    public String criptografar(String password) {
        BasicPasswordEncryptor objeto = new BasicPasswordEncryptor();
        String hashSenha = objeto.encryptPassword(password);
        return hashSenha;
    }

    public Boolean checkPassword(String password, String hashPassword) {
        BasicPasswordEncryptor objeto = new BasicPasswordEncryptor();
        return objeto.checkPassword(password, hashPassword);
    }

}