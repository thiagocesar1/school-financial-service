package br.com.school.financialservice.rest.mappers;

import br.com.school.financialservice.domain.entity.Client;
import br.com.school.financialservice.rest.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientDTO clientDTO);
}
