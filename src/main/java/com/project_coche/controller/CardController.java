package com.project_coche.controller;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.dto.CustomerDto;
import com.project_coche.domain.useCase.ICardService;
import com.project_coche.exceptions.UnauthorizadException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cards")
public class CardController {

    @Autowired
    private final ICardService cardService;


    @GetMapping()
    public ResponseEntity<List<CardDto>> getAllCards() throws UnauthorizadException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardService.getAll());
    }

    @GetMapping(path = "/brandCard/{idBrandCard}")
    public ResponseEntity<List<CardDto>> getbyIdBrandCard(@PathVariable("idBrandCard") Integer idBrandCard) {
        return ResponseEntity.ok(cardService.getByIdBrandCard(idBrandCard));
    }


    @GetMapping(path = "/carId/{carId}")
    public ResponseEntity<CardDto> getCardById(@PathVariable("carId") Integer carId) {
        return ResponseEntity.of(cardService.getById(carId));
    }

    @GetMapping(path = "/price/{priceCard}")
    public ResponseEntity<List<CardDto>> getCarsByPriceLessThan(@PathVariable double priceCard) {
        return ResponseEntity.ok(cardService.getCardsByPriceLessThan(priceCard));
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
        return new ResponseEntity<>(this.cardService.delete(id_vehiculo) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}
