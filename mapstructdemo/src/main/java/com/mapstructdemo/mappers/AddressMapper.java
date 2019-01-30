package com.mapstructdemo.mappers;

import org.mapstruct.Mapper;

import com.mapstructdemo.model.AddressDto;

@Mapper
public interface AddressMapper {
	AddressDto adderssToAddressDto(AddressDto addressDto);
}
