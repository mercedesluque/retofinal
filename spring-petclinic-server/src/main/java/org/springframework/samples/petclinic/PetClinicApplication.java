package org.springframework.samples.petclinic;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.config.PetclinicProperties;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableConfigurationProperties(PetclinicProperties.class)
public class PetClinicApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }
    
    @Bean
	public CommandLineRunner demoVetRepository(ClinicService clinicService) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");
			
//			log.info("Probando visitRepository");
//			List<Visit> visitas = (List<Visit>) clinicService.findVisitByOwner(6);
//			for(Visit v: visitas){
//				log.info("visita -> "+v.toString());
//			}
//			
			
//			log.info("Voy a crear 2 visitas");
//			RequestVisit rv = new RequestVisit();
//			rv.setDate(new Date());
//			rv.setOwner(clinicService.findOwnerById(1));
//			rv.setPet(clinicService.findPetById(1));
//			rv.setVet(((List<Vet>)clinicService.findVets()).get(1));
//			
//			clinicService.saveRequestVisit(rv);
//						
//			log.info("Traemos la lista de RequestVisits");
//			for(RequestVisit r: clinicService.findRequestVisitByOwner(1)){
//				log.info("Request Visit -> "+r.toString());
//			}
			
		};
	}
    
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("/**");
            }
        };
    }
    
}

