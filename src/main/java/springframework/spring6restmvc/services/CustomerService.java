package springframework.spring6restmvc.services;

import springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    Optional<CustomerDTO> getCustomerById(UUID uuid);
    List<CustomerDTO> getAllCustomers();

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    Optional<CustomerDTO> updateCustomerById(UUID uuid, CustomerDTO customer);

    Boolean deleteCustomerById(UUID uuid);

    Optional<CustomerDTO> patchCustomerById(UUID uuid, CustomerDTO customer);
}
