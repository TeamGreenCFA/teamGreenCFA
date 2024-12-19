package team.green.cfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

@RestController
@RequestMapping("/api/vol")
public class VolController {

    private VolService volService;
    private VolDtoToVol volDtoToVol;
    private VolToVolDto volToVolDto;

    @Autowired
    public void setVolService(VolService volService) {
        this.volService = volService;
    }

    @Autowired
    public void setVolDtoToVol(VolDtoToVol volDtoToVol) {
        this.volDtoToVol = volDtoToVol;
    }
    @Autowired
    public void setVolToVolDto(VolToVolDto volToVolDto) {
        this.volToVolDto = volToVolDto;
    }
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<VolDto>> listVols() {

        List<VolDto> VolDtos = volService.getVolList().stream()
                .map(volModel -> volToVolDto.convert(volModel))
                .collect(Collectors.toList());

        return new ResponseEntity<>(VolDtos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<VolDto> showVol(@PathVariable Integer id) {

        VolModel volModel = volService.get(id);

        if (volModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(volToVolDto.convert(volModel), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addVol(@Valid @RequestBody VolDto volDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

       if (bindingResult.hasErrors() || volDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }



        volService.saveOrUpdate(volDtoToVol.convert(volDto));





        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<VolDto> editVol(@Valid @RequestBody VolDto volDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (volDto.getId() != null && !volDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (volService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        volDto.setId(id);

        volService.saveOrUpdate(volDtoToVol.convert(volDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<VolDto> deleteVol(@PathVariable Integer id) {

        volService.deleteVon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

}