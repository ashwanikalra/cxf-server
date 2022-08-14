package org.example.cxfserver.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.example.cxfserver.customer.CustomerServiceEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFServerConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(CustomerServiceEndpoint customerServiceEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, customerServiceEndpoint);
        endpoint.publish("/service/customer");
        return endpoint;
    }
}
