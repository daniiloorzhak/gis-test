package ru.oorzhak.recordservice.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.oorzhak.recordservice.model.Record;

public interface RecordRepository extends R2dbcRepository<Record, Long> {
    Flux<Record> findByUserId(Long userId);
}
