package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.ClientDto;
import com.patskevich.planetexpress.entity.Client;
import com.patskevich.planetexpress.utils.IdWriter;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ClientConverter implements IDtoEntityConverter<ClientDto, Client> {

    public ClientDto convertToDto(final Client client) {
        final ClientDto clientDto = new ClientDto();
        clientDto.setName(IdWriter.write(client.getId(),client.getName()));
        return clientDto;
    }

    public Client convertToEntity(final ClientDto clientDto) {
        Assert.isTrue(false,"This shall never happen");
        return null;
    }
}
