package br.com.school.financialservice.rest.mappers;

import br.com.school.financialservice.domain.entity.Payment;
import br.com.school.financialservice.rest.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ClientMapper.class })
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper( PaymentMapper.class );

    @Mapping(source = "client", target = "client")
    Payment toPayment(PaymentDTO paymentDTO);
}
