package ru.oorzhak.authservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.oorzhak.authservice.model.Session;

public interface SessionRepository extends CrudRepository<Session, String> {
    Session findByUserId(Long userID);
}
