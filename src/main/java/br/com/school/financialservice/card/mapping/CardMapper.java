package br.com.school.financialservice.card.mapping;

import br.com.school.financialservice.card.domain.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class );
    
    Card toCard(CardDTO cardDTO);
}
