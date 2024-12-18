package team.green.cfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import team.green.cfo.command.BenDto;
import team.green.cfo.converters.BenDtoToBen;
import team.green.cfo.converters.BenToBenDto;
import team.green.cfo.models.BenModel;
import team.green.cfo.services.BenService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("")
public class BenController {
    private BenService benService;
    private BenDtoToBen benDtoToBen;
    private BenToBenDto benToBenDto;

    @Autowired
    public void setBenService(BenService benService) {
        this.benService = benService;
    }

    @Autowired
    public void setBenDtoToBen(BenDtoToBen benDtoToBen) {
        this.benDtoToBen = benDtoToBen;
    }
    @Autowired
    public void setBenToBenDto(BenToBenDto benToBenDto) {
        this.benToBenDto = benToBenDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<BenDto>> listBens() {

        List<BenDto> BenDtos = benService.getBenList().stream()
                .map(benModel -> benToBenDto.convert(benModel))
                .collect(Collectors.toList());

        return new ResponseEntity<>(BenDtos, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<BenDto> showBen(@PathVariable Integer id) {

        BenModel benModel = benService.get(id);

        if (benModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(benToBenDto.convert(benModel), HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addBen(@Valid @RequestBody BenDto benDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || benDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BenModel savedBen = benService.saveOrUpdate(benDtoToBen.convert(benDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/ben/" + savedBen.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<BenDto> editBen(@Valid @RequestBody BenDto benDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (benDto.getId() != null && !benDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (benService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        benDto.setId(id);

        benService.saveOrUpdate(benDtoToBen.convert(benDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }




    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<BenDto> deleteBen(@PathVariable Integer id) {

        benService.deleteBen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
}
