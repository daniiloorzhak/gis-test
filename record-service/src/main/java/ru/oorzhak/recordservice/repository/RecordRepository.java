package ru.oorzhak.recordservice.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RecordRepository extends R2dbcRepository<Record, Long> {
    @Override
    Mono<Record> findById(Long aLong);
}
