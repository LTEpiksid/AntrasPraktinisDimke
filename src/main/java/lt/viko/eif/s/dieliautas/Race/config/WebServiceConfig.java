package lt.viko.eif.s.dieliautas.Race.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    /**
     * Registruoja SOAP žinučių siuntimo servletą.
     * @param applicationContext Kontekstas, kuriame vykdoma programa.
     * @return Registracijos objektas servletui.
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Sukuria WSDL apibrėžimą paslaugai "racers".
     * @param racersSchema XSD schema, apibrėžianti paslaugos struktūrą.
     * @return WSDL apibrėžimo objektas.
     */
    @Bean(name = "racers")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema racersSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("RacersPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/racers");
        definition.setSchema(racersSchema);
        return definition;
    }

    /**
     * Įkelia ir grąžina XSD schemos objektą.
     * @return XSD schema iš resursų katalogo.
     */
    @Bean
    public XsdSchema racersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("racers.xsd"));
    }
}

//http://localhost:8080/ws/racers.wsdl
