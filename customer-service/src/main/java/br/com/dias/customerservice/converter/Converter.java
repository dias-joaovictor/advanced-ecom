package br.com.dias.customerservice.converter;

import br.com.dias.customerservice.entity.EcommerceEntity;
import br.com.dias.customerservice.model.inbound.request.EcommerceRequest;
import br.com.dias.customerservice.model.inbound.response.EcommerceResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Converter interface
 *
 * @param <REQ>  Request object
 * @param <RESP> Response object
 * @param <E>    Entity object
 */
public interface Converter<REQ extends EcommerceRequest, RESP extends EcommerceResponse, E extends EcommerceEntity> {
    E convert(REQ request);

    RESP convert(E entity);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void merge(@MappingTarget E target, E source);
}
