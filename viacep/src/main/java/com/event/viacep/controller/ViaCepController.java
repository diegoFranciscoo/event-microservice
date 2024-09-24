package com.event.viacep.controller;

import com.event.viacep.dto.AddressDTO;
import com.event.viacep.feign.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViaCepController {
    private final ViaCepClient viaCepClient;

    public ViaCepController(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @GetMapping("/address/{cep}")
    public AddressDTO getAddress(@PathVariable String cep) {
        return viaCepClient.getAddress(cep);
    }
}
