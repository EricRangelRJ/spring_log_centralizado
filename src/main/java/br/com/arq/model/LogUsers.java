package br.com.arq.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "logusers")
public class LogUsers {

    @Id
    private String id;
    private String typeLog;
    private String message;
    @Indexed
    private String usersId;
    private LocalDateTime dataHora;


}
