package br.com.arq.repository;

import br.com.arq.model.LogUsers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogUsersRepository extends MongoRepository<LogUsers, String> {

    public List<LogUsers> findByUsersId(String usersId);

}
