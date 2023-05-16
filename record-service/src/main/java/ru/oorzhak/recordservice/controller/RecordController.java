package ru.oorzhak.recordservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.oorzhak.recordservice.dto.RecordDTO;
import ru.oorzhak.recordservice.model.Record;
import ru.oorzhak.recordservice.service.RecordService;

@RestController
@RequestMapping("record")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public Flux<Record> getAllUserRecords(@CookieValue(value = "session-id") String sessionId) {
        return recordService.findUserRecords(sessionId);
    }

    @PostMapping
    public ResponseEntity<?> createRecord(
            @RequestBody @Valid RecordDTO recordDTO,
            @CookieValue(value = "session-id") String sessionId) {
        return ResponseEntity.ok(recordService.save(recordDTO, sessionId));
    }

}
