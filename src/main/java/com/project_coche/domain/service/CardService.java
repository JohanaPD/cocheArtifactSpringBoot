package com.project_coche.domain.service;

import com.project_coche.domain.dto.CardDto;
import com.project_coche.domain.repository.ICardRepository;
import com.project_coche.domain.useCase.ICardService;
import com.project_coche.exceptions.UnauthorizadException;
import com.project_coche.persistence.entities.CarEntity;
import com.project_coche.persistence.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    private final ICardRepository iCardRepository;
    private final ICarMapper icardMapper;


    @Override
    public List<CardDto> getAll() throws UnauthorizadException {
      /*  //Aquí puedo llamar roles
        Collection<? extends GrantedAuthority> listaRoles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if(listaRoles.stream().noneMatch(role -> String.valueOf(role).equalsIgnoreCase("CUSTOMER"))){
            throw  new UnauthorizadException();
        }
        //Validación por nivel de servicio
        if(listaRoles.stream().anyMatch(role -> String.valueOf(role).equalsIgnoreCase("Junior"))){
            //
        }*/

        return iCardRepository.getAll();
    }

    @Override
    public Optional<CardDto> getById(Integer id) {
        return iCardRepository.getById(id);
    }

    @Override
    public List<CardDto> getByIdBrandCard(Integer idBrandCard) {
        return iCardRepository
                .getByIdBrandCard(idBrandCard);
    }

    @Override
    public List<CardDto> getCardsByPriceLessThan(double price) {
        return iCardRepository
                .getCardsByPriceLessThan(price);
    }

    @Override
    public CardDto save(CardDto cardDto) {
        CarEntity carEntity =icardMapper.toCardEntity(cardDto) ;
        System.out.println("Price a persistir: " + carEntity.getPrice());
        return iCardRepository
                .save(cardDto);
    }

    @Override
    public Optional<CardDto> update(CardDto cardDto) {
        System.out.println(cardDto.getId_vehiculo());
        if (cardDto.getId_vehiculo() == null) {
            throw new IllegalArgumentException("El ID del vehículo no puede ser nulo");
        }
        if (iCardRepository
                .getById(cardDto
                        .getId_vehiculo())
                .isEmpty()) {
            return Optional.empty();
        }
        return Optional
                .of(iCardRepository
                        .save(cardDto));
    }

    @Override
    public boolean delete(Integer idCard) {
        if (iCardRepository
                .getById(idCard)
                .isEmpty()) {
            return false;
        }
        iCardRepository.delete(idCard);
        return true;

    }
}
