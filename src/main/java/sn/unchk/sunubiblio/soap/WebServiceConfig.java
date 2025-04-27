package sn.unchk.sunubiblio.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "livres")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema livresSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("LivresPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://sunubiblio.sn/soap");
        wsdl11Definition.setSchema(livresSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema livresSchema() {
        return new SimpleXsdSchema(new org.springframework.core.io.ClassPathResource("xsd/livre.xsd"));
    }

    @Bean
public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(
        sn.unchk.sunubiblio.soap.dto.AjouterLivreRequest.class,
        sn.unchk.sunubiblio.soap.dto.AjouterLivreResponse.class,
        sn.unchk.sunubiblio.soap.dto.ModifierLivreRequest.class,
        sn.unchk.sunubiblio.soap.dto.ModifierLivreResponse.class,
        sn.unchk.sunubiblio.soap.dto.SupprimerLivreRequest.class,
        sn.unchk.sunubiblio.soap.dto.SupprimerLivreResponse.class,
        sn.unchk.sunubiblio.soap.dto.PreterLivreRequest.class,
        sn.unchk.sunubiblio.soap.dto.PreterLivreResponse.class,
        sn.unchk.sunubiblio.soap.dto.RetournerLivreRequest.class,
        sn.unchk.sunubiblio.soap.dto.RetournerLivreResponse.class
    );
    return marshaller;
}

}
