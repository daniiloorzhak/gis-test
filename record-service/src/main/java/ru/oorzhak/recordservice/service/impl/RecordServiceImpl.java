package ru.oorzhak.recordservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.oorzhak.recordservice.client.AuthClient;
import ru.oorzhak.recordservice.dto.RecordDTO;
import ru.oorzhak.recordservice.model.Record;
import ru.oorzhak.recordservice.repository.RecordRepository;
import ru.oorzhak.recordservice.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final AuthClient authClient;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository, AuthClient authClient) {
        this.recordRepository = recordRepository;
        this.authClient = authClient;
    }

    @Override
    public Flux<Record> findUserRecords(String sessionId) {
        long userId = authClient.getUserId(sessionId);
        return recordRepository.findByUserId(userId);
    }

    @Override
    public Mono<Record> save(RecordDTO recordDTO, String sessionId) {
        return null;
    }
}
