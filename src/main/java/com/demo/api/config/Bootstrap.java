package com.demo.api.config;

import com.demo.api.services.PersonService;
import com.demo.api.v1.dto.PersonDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Bootstrap implements CommandLineRunner {

    private PersonService personService;

    public Bootstrap(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        PersonDTO p1 = new PersonDTO();
        p1.setFirstName("Pepito Bootstrap 1");
        p1.setLastName("Perez Bootstrap 1");
        p1.setNuip(1234567890l);
        p1.setBirthdate(LocalDate.now());
        p1.setObservation("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
                " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa" +
                " qui officia deserunt mollit anim id est laborum.");
        p1.setEmail("correo1@mailto.com");

        PersonDTO p2 = new PersonDTO();
        p2.setFirstName("Pepito Bootstrap 2");
        p2.setLastName("Perez Bootstrap 2");
        p2.setNuip(1012345678l);
        p2.setBirthdate(LocalDate.now());
        p2.setObservation("Sed ut perspiciatis unde omnis iste natus error sit voluptatem " +
                "accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo" +
                " inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo " +
                "enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia " +
                "consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro " +
                "quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, " +
                "sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam " +
                "quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam " +
                "corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem " +
                "vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae " +
                "consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        p2.setEmail("correo2@mailto.com");

        personService.createPerson(p1);
        personService.createPerson(p2);
    }
}
