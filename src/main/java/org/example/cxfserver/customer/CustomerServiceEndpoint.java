package org.example.cxfserver.customer;

import com.abc.customer.Customer;
import com.abc.customer.CustomerServicePortType;
import com.abc.customer.GetCustomerRequest;
import com.abc.customer.GetCustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CustomerServiceEndpoint implements CustomerServicePortType {

    @Override
    public GetCustomerResponse getCustomer(GetCustomerRequest customerRequest) {
        GetCustomerResponse customerResponse = new GetCustomerResponse();
        try {
            //return hard coded response
            Customer customer = new Customer();
            customer.setFirstname("Robert");
            customer.setLastname("Brown");
            customer.setId(123);
            customerResponse.setCustomer(customer);
        } catch (Exception e) {
            log.error("Error while setting values for employee object", e);
        }
        log.debug("returning the response...");
        return customerResponse;
    }
}