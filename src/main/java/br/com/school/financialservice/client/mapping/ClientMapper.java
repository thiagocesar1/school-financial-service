package br.com.school.financialservice.client.mapping;

import br.com.school.financialservice.client.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientDTO clientDTO);
}
