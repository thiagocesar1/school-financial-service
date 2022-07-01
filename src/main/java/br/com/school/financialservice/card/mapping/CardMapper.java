package br.com.school.financialservice.card.mapping;

import br.com.school.financialservice.card.domain.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class );
    @Mapping(source = "validationDate", target = "validationDate", dateFormat = "yyyy-MM-dd")
    Card toCard(CardDTO cardDTO);
}
