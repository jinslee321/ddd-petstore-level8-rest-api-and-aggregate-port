package com.hea.eztalk;

// import com.example.petstore.domain.Pet;
import com.hea.eztalk.domain.Pet;
import com.hea.eztalk.domain.Cat;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Pet>> {

    @Override
    public EntityModel<Pet> process(EntityModel<Pet> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));

        if(model.getContent() instanceof Cat)
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));

        return model;
    }
}