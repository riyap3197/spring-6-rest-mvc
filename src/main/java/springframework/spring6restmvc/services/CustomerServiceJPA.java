package springframework.spring6restmvc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import springframework.spring6restmvc.mappers.CustomerMapper;
import springframework.spring6restmvc.model.CustomerDTO;
import springframework.spring6restmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID uuid, CustomerDTO customer) {

    }

    @Override
    public void deleteCustomerById(UUID uuid) {

    }

    @Override
    public void patchCustomerById(UUID uuid, CustomerDTO customer) {

    }
}
