package springframework.spring6restmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springframework.spring6restmvc.model.Customer;
import springframework.spring6restmvc.services.CustomerService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class CustomerController {

    public static final String CUSTOMER_PATH="/api/v1/customer";
    public static final String CUSTOMER_PATH_ID= CUSTOMER_PATH + "/{customerId}";

    private final CustomerService customerService;

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustomerPatchById(@PathVariable("customerId") UUID uuid,
                                                  @RequestBody Customer customer){
        customerService.patchCustomerById(uuid, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("customerId") UUID uuid){
        customerService.deleteCustomerById(uuid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("customerId") UUID uuid,@RequestBody Customer customer){
        customerService.updateCustomerById(uuid, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    private ResponseEntity handlePost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveNewCustomer(customer);
        HttpHeaders headers =new HttpHeaders();
        headers.add("Location","/api/v1/customer/" + savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(CUSTOMER_PATH)
    private List<Customer> listAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(CUSTOMER_PATH_ID)
    private Customer getCustomerById(@PathVariable("customerId") UUID uuid){
        return customerService.getCustomerById(uuid);
    }

}
