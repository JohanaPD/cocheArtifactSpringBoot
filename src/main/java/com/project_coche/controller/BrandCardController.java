package com.project_coche.controller;


import com.project_coche.domain.dto.BrandCardDto;
import com.project_coche.domain.useCase.IBrandCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brandCard")
public class BrandCardController {

    private final IBrandCardService brandCardService;

    @GetMapping()
    public ResponseEntity<List<BrandCardDto>> getAllBrandCards() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(brandCardService.getAll());
        //return ResponseEntity.ok(brandCardService.getAll());
        //return new ResponseEntity<>(brandCardService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCardDto> getBrandCardById(@PathVariable int id) {
        return ResponseEntity.of(brandCardService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<BrandCardDto> save(@RequestBody BrandCardDto brandCardDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(brandCardService.save(brandCardDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PatchMapping()
    public ResponseEntity<BrandCardDto> updateBrandCardPojo(@RequestBody BrandCardDto brandCardPojoupdate) {
        return ResponseEntity.of(brandCardService.update(brandCardPojoupdate));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return new ResponseEntity<>(this.brandCardService.delete(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
