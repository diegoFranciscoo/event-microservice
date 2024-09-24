package com.event.manager.feign;

import com.event.manager.dto.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gateway", url = "http://localhost:8082")
public interface GatewayClient {

    @GetMapping("/address/{cep}")
    Address getAddress(@PathVariable String cep);
}
