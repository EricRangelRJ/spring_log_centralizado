package br.com.arq.repository;

import br.com.arq.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users,String> {

    public Users findByEmail(String email); //Cita o método
}
