package com.project_coche.controller;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.useCase.ICardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cards")
public class CardController {

    private final ICardService cardService;


    @GetMapping()
    public ResponseEntity<List<CardDto>> getAllCards() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardService.getAll());
    }

    @GetMapping(path = "/{idBrandCard}")
    public ResponseEntity<List<CardDto>> getbyIdBrandCard(@PathVariable("idBrandCard") Integer idBrandCard) {
        return ResponseEntity.ok(cardService.getByIdBrandCard(idBrandCard));
    }



    @GetMapping(path = "/{id_vehiculo}")
    public ResponseEntity<CardDto> getCardById(@PathVariable("id_vehiculo") Integer id) {
        return ResponseEntity.of(cardService.getById(id));
    }



    @PostMapping()
    public ResponseEntity<CardDto> saveCard(@RequestBody CardDto cardDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cardService.save(cardDto));
    }

    @PatchMapping()
    public ResponseEntity<CardDto> updateCard(@RequestBody CardDto cardDto) {
        return ResponseEntity.of(cardService.update(cardDto));
    }

    @DeleteMapping(path = "/{id_vehiculo}")
    public ResponseEntity<Boolean> deleteCard(@PathVariable Integer id_vehiculo) {
        return  new ResponseEntity<>(this.cardService.delete(id_vehiculo)? HttpStatus.OK : HttpStatus.NOT_FOUND );
    }


}
