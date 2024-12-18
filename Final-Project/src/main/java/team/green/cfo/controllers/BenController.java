package team.green.cfo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.green.cfo.command.BenDto;
import team.green.cfo.converters.BenDtoToBen;
import team.green.cfo.converters.BenToBenDto;
import team.green.cfo.services.BenService;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin
//@RequestMapping("")
public class BenController {
    private BenService benService;
    private BenDtoToBen benDtoToBen;
    private BenToBenDto benToBenDto;

    //@Autowired
    public void setBenService(BenService benService) {
        this.benService = benService;
    }
    //@Autowired
    public void setBenDtoToBen(BenDtoToBen benDtoToBen) {
        this.benDtoToBen = benDtoToBen;
    }
    public void setBenToBenDto(BenToBenDto benToBenDto) {
        this.benToBenDto = benToBenDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<BenDto>> listBens() {

        List<BenDto> BenDtos = BenService.list().stream()
                .map(customer -> benToBenDto.convert(benModel))
                .collect(Collectors.toList());

        return new ResponseEntity<>(BenDtos, HttpStatus.OK);



    /*@RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<BenDto> showBen(@PathVariable Integer id) {

        Ben ben = benService.get(id);

        if (ben == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(BenToBenDto.convert(ben), HttpStatus.OK);
    }

     */

    /*@RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addBen(@Valid @RequestBody BenDto benDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || benDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ben savedBen = benService.save(benDtoToBen.convert(benDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/ben/" + savedBen.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

     */
    /*@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<BenDto> editBen(@Valid @RequestBody BenDto benDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (benDto.getId() != null && !benDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (benService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        benDto.setId(id);

        benService.save(benDtoToBen.convert(benDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

     */


    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<BenDto> deleteBen(@PathVariable Integer id) {

        try {

            benService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (AssociationExistsException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (BenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
