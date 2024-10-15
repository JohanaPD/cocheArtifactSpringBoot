    package com.project_coche.controller;

    import com.project_coche.domain.dto.AuthCustomerDto;
    import com.project_coche.domain.dto.JwtResponseDto;
    import com.project_coche.domain.useCase.IAuthUseCase;
    import com.project_coche.exceptions.CustomerNotExistException;
    import com.project_coche.exceptions.PasswordIncorrectException;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RequiredArgsConstructor
    @RestController
    @RequestMapping(path = "/auth")
    public class AuthController {
        private final IAuthUseCase iAuthUseCase;

        @GetMapping
        public ResponseEntity<JwtResponseDto> prueba() {
              return ResponseEntity.ok(new JwtResponseDto("Prueba"));
        }

        @PostMapping(path = "/sign-in")
        public ResponseEntity<JwtResponseDto> sigIn(@RequestBody AuthCustomerDto authCustomerDto) throws CustomerNotExistException, PasswordIncorrectException {
            System.out.println("Email recibido: " + authCustomerDto.getEmail());
            System.out.println("Password recibido: " + authCustomerDto.getPassword());
            return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDto));
        }

        @PostMapping(path = "/sign-out")
        public ResponseEntity<JwtResponseDto> sigOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
            return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
        }

    }
