package com.data.system.company.service;


import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.AddressDto;
import com.data.system.company.model.entity.Address;
import com.data.system.company.model.mapper.Mapper;
import com.data.system.company.reporistary.AddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddRepo addRepo;

    @Autowired
    private Mapper mapper;

    public Address addAddress(Address address){
        return addRepo.save(address);
    }
    public AddressDto addressById(int addressId){
        AddressDto address=addRepo.findAddressById(addressId)
                .orElseThrow(()->new ResourceNotFoundException("not found address"));

        return address;
    }

    public List<AddressDto> getAllAddress(){
        List<Address> addresses=addRepo.findAll();
        if(addresses.isEmpty())
            throw new ResourceNotFoundException("not founds Address");

        List<AddressDto> addressDtos=addresses.stream()
                .map(a->mapper.toAddressDto(a))
                .collect(Collectors.toList());
        return addressDtos;
    }
    public List<AddressDto> gettAllAddressPrime(){
        return addRepo.findAddressAll();
    }
}
