package com.example.mobilephoneopeningservice.dto;

import com.example.mobilephoneopeningservice.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto extends BaseDto{
    private Long id;
    private String customerId;
    private String name;
    private String phoneNumber;
    private String birthday;

    public static CustomerDto entityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setName(customer.getName());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setBirthday(customer.getBirthday());
        customerDto.setCreatedDt(customer.getCreatedDt());
        customerDto.setUpdatedDt(customer.getUpdatedDt());
        return customerDto;
    }

    public static Customer dtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setBirthday(customerDto.getBirthday());
        customer.setCreatedDt(customerDto.getCreatedDt());
        customer.setUpdatedDt(customerDto.getUpdatedDt());
        return customer;
    }
}