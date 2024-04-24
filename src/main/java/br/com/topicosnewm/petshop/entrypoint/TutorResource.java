package br.com.topicosnewm.petshop.entrypoint;

import br.com.topicosnewm.petshop.service.tutor.TutorService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
@Api(tags = "Tutor", description = "Controller de tutor")
public class TutorResource {
    @Autowired
    private TutorService tutorService;

    @Autowired
    private ModelMapper mapper;
}
