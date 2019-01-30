package com.mapstructdemo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.mapstructdemo.model.Customer;
import com.mapstructdemo.model.CustomerDto;

@Mapper(uses=AddressMapper.class)
public interface CustomerMapper {
	
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mappings({
	@Mapping(target="name", source="secondName"),
	@Mapping(target="dob", dateFormat="dd.MM.yyyy")})
	CustomerDto customerToCustomerDto(Customer source);
}
