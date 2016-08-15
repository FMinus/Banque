
package org.Banque;

import org.Banque.rmi.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;


@Configuration //methode 2 : exposer un service web : java configuration
public class MyConfig
{
    @Bean
    public SimpleJaxWsServiceExporter getJWS()
    {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8089/maBanque");
        
        return exporter;
    }
    
    @Bean
    public RmiServiceExporter getRmiService(ApplicationContext context)
    {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(context.getBean("myRmiService"));
        exporter.setRegistryPort(1099);
        exporter.setServiceName("BK");
        exporter.setServiceInterface(BanqueRmiRemote.class);
        
        return exporter;
    }
}
