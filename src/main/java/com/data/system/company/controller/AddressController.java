package com.data.system.company.controller;


import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.AddressDto;
import com.data.system.company.model.entity.Address;
import com.data.system.company.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAllAddress")
    public ResponseEntity<List<AddressDto>> getalladdress(){
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }
    @GetMapping("/getAllAddressPrime")
    public ResponseEntity<List<AddressDto>> getalladdressprime(){
        return new ResponseEntity<>(addressService.gettAllAddressPrime(), HttpStatus.OK);
    }

    @GetMapping("/getAddressById")
    public ResponseEntity<AddressDto> addressById(@RequestParam int addressId){
        AddressDto address=addressService.addressById(addressId);
        return  new ResponseEntity<>(address,HttpStatus.OK);
    }




}
