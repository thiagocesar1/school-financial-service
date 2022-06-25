package br.com.school.financialservice.payment.mapping;

import br.com.school.financialservice.client.mapping.ClientMapper;
import br.com.school.financialservice.payment.domain.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ClientMapper.class })
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper( PaymentMapper.class );

    @Mapping(source = "client", target = "client")
    Payment toPayment(PaymentDTO paymentDTO);
}
