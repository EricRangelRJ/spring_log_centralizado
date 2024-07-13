package br.com.arq.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "users")
public class Users {

    @Id
	private String id;
	private String name;
	@Indexed(unique = true)
    private String email;
	private String status;
	private String token;
    private String password;
	private LocalDateTime data;

}
