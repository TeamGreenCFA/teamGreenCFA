package team.green.cfo.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import team.green.cfo.command.VolDto;
import team.green.cfo.converters.BenToBenDto;
import team.green.cfo.converters.VolDtoToVol;
import team.green.cfo.converters.VolToVolDto;
import team.green.cfo.models.VolModel;
import team.green.cfo.services.VolService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public class VolController {

    private VolService volService;
    private VolDtoToVol volDtoToVol;
    private VolToVolDto volToVolDto;

    //@Autowired
    public void setVolService(VolService volService) {
        this.volService = volService;
    }
    //@Autowired
    public void setVolDtoToVol(VolDtoToVol volDtoToVol) {
        this.volDtoToVol = volDtoToVol;
    }
    public void setBenToBenDto(BenToBenDto benToBenDto) {
        this.volToVolDto = volToVolDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<VolDto>> listVols() {

        List<VolDto> VolDtos = VolService.list().stream()
                .map(volModel -> volToVolDto.convert(volModel))
                .collect(Collectors.toList());

        return new ResponseEntity<>(VolDtos, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<VolDto> showVol(@PathVariable Integer id) {

        VolModel volModel = volService.get(id);

        if (volModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(VolToVolDto.convert(volModel), HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addVol(@Valid @RequestBody VolDto volDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || volDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        VolModel savedVol = volService.save(volDtoToVol.convert(volDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/ben/" + savedVol.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<VolDto> editVol(@Valid @RequestBody VolDto volDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (volDto.getId() != null && !volDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (volService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        volDto.setId(id);

        volService.save(volDtoToVol.convert(volDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }




    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<VolDto> deleteVol(@PathVariable Integer id) {

        try {

            volService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (AssociationExistsException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (VolNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}