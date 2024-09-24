package com.event.viacep.feign;

import com.event.viacep.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepClient {
    @GetMapping("{cep}/json/")
    AddressDTO getAddress(@PathVariable String cep);
}

