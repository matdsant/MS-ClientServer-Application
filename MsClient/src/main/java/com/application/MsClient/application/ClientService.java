package com.application.MsClient.application;

import com.application.MsClient.infra.repository.ClientRepository;
import com.application.MsClient.domain.Client;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    public Optional<Client> getByCPF(String cpf) {
        return repository.findByCpf(cpf);
    }
}
