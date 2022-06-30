package br.com.school.financialservice.payment.mapping;

import br.com.school.financialservice.payment.domain.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper( PaymentMapper.class );

    @Mapping(source = "clientName", target = "client.name")
    @Mapping(source = "clientEmail", target = "client.email")
    @Mapping(source = "clientMarketingLeadId", target = "client.marketingLeadId")
    @Mapping(source = "clientDocument", target = "client.document")
    Payment toPayment(PaymentDTO paymentDTO);
}
