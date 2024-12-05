package ma.emsi.soap_spring.config;

import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.Bus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;
import ma.emsi.soap_spring.service.CompteSoapService;

@Configuration
public class SoapConfig {

    private final Bus bus;
    private final CompteSoapService compteSoapService;

    public SoapConfig(Bus bus, CompteSoapService compteSoapService) {
        this.bus = bus;
        this.compteSoapService = compteSoapService;
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, compteSoapService);
        endpoint.publish("/BanqueWS"); // Assurez-vous que le chemin correspond ici
        return endpoint;
    }
}
