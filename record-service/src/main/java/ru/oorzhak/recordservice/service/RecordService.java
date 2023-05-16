package ru.oorzhak.recordservice.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.oorzhak.recordservice.dto.RecordDTO;
import ru.oorzhak.recordservice.model.Record;

public interface RecordService {
    Flux<Record> findUserRecords(String sessionId);
    Mono<Record> save(RecordDTO recordDTO, String sessionId);
}
