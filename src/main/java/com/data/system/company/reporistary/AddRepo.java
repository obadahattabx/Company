package com.data.system.company.reporistary;

import com.data.system.company.model.dto.AddressDto;
import com.data.system.company.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddRepo extends JpaRepository<Address,Integer> {

@Query(value = "SELECT new com.data.system.company.model.dto.AddressDto(a.id,a.city,a.streetAddress,a.postalCode) From Address a where a.id= :id")
Optional<AddressDto> findAddressById(@Param("id")int id);

@Query(value = "SELECT new com.data.system.company.model.dto.AddressDto(a.id,a.city,a.streetAddress,a.postalCode) FROM Address a")
List<AddressDto> findAddressAll();
}
