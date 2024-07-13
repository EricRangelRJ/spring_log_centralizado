package br.com.arq.dto;

import br.com.arq.model.LogUsers;
import br.com.arq.model.Users;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    //Campos do usuário
    private String id;
    private String name;
    private String email;
    private String status;
//    private String token;
    private String password;
    private LocalDateTime dataMovimentacao;


    //Campos do Log
    private String idLog;
    private String typeLog;
    private String message;
    private String usersId;
    private LocalDateTime dataHora;

    //Construtor com dados dos Usuários
    public UsersDto(String id, String name, String email, String status, String token, String password,
                    LocalDateTime dataMovimentacao) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
//        this.token = token;
        this.password = password;
        this.dataMovimentacao = dataMovimentacao;
    }

    //Construtor com dados do Log
    public UsersDto(String idLog, String typeLog, String message, String usersId, LocalDateTime dataHora) {
        super();
        this.idLog = idLog;
        this.typeLog = typeLog;
        this.message = message;
        this.usersId = usersId;
        this.dataHora = dataHora;
    }

    //gravacao (Entrada)
    public Users toUsersCreateDocument() {
        Users users = new Users();
        users.setName(this.name);
        users.setEmail(this.email); // o usuario envia isso
        users.setPassword(this.password);
        users.setData(LocalDateTime.now());
        users.setStatus("CREATED");


        return users;
    }

    //Logar Usuário
    public LogUsers toLogUsersDocument(String usersId) {
        LogUsers log = new LogUsers();
        log.setMessage(this.message);
        log.setTypeLog(this.typeLog);
        log.setUsersId(usersId);
        return log;
    }

}

