package br.com.arq.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arq.dto.UsersDto;
import br.com.arq.model.LogUsers;
import br.com.arq.model.Users;
import br.com.arq.repository.LogUsersRepository;
import br.com.arq.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private CriptografiaService criptografiaService;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private LogUsersRepository logUsersRepository;


    public Object saveUsers(UsersDto dto) throws Exception{
        try {

            var user = usersRepository.findByEmail(dto.getEmail());
            if(Objects.nonNull(user)){
                throw new Exception("Conta com endereço de email já cadastrada!");
            }

            Users users = dto.toUsersCreateDocument();

            users.setPassword(criptografiaService.criptografar(users.getPassword()));

            Users respostaSave = usersRepository.save(users);

            LogUsers log = dto.toLogUsersDocument(respostaSave.getId());
            log.setTypeLog("INFO");
            log.setMessage("Users Save");
            log.setDataHora(LocalDateTime.now());
            logUsersRepository.save(log);
            return respostaSave;
        }catch(Exception ex) {
            LogUsers log = dto.toLogUsersDocument("000000000000000000099999");
            log.setTypeLog("ERROR");
            log.setMessage("Error : " + ex.getMessage() + "," + dto.getEmail());
            log.setDataHora(LocalDateTime.now());
            logUsersRepository.save(log);
            throw new Exception(ex.getMessage());
        }
    }

    public Object loginUsers(UsersDto dto) throws Exception{
        try {
            Users users = dto.toUsersCreateDocument();
            Users login = usersRepository.findByEmail(users.getEmail());

            Boolean resposta = criptografiaService.checkPassword(users.getPassword(),  login.getPassword());

            if (resposta) {
                LogUsers log = dto.toLogUsersDocument(login.getId());
                log.setTypeLog("INFO");
                log.setMessage("Users Login");
                log.setDataHora(LocalDateTime.now());
                logUsersRepository.save(log);

            }else {
                throw new Exception("Error na Criptografia");
            }

            return login;

        }catch(Exception ex) {
            LogUsers log = dto.toLogUsersDocument("000000000000000000088888");
            log.setTypeLog("ERROR");
            log.setMessage("Error :" + ex.getMessage());
            log.setDataHora(LocalDateTime.now());
            logUsersRepository.save(log);
            throw new Exception(ex.getMessage());
        }

    }



}
