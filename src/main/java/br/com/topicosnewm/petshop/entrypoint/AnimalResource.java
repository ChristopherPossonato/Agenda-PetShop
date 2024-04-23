package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.service.animal.AnimalService;
import br.com.topicosnewm.petshop.service.tutor.TutorService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animais")
@Api(tags = "Animais", description = "Controller de animais")
public class AnimalResource {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ModelMapper mapper;

}
