package team.green.cfo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import team.green.cfo.command.BenDto;
import team.green.cfo.models.BenModel;
import team.green.cfo.services.BenService;
@Component
public class BenDtoToBen implements Converter<BenDto, BenModel> {

    private BenService benService;

    public void setBenService(BenService benService) {
        this.benService = benService;
    }

    public BenModel convert(BenDto benDto) {
        BenModel benModel = (benDto.getId() != null ? benService.get(benDto.getId()) : new BenModel());

        benModel.setFirstName(benDto.getFirstName());
        benModel.setLastName(benDto.getLastName());
        benModel.setEmail(benDto.getEmail());
        benModel.setPhone(benDto.getPhone());
        benModel.setAddress(benDto.getAddress());
        benModel.setAge(benDto.getAge());
        benModel.setDescriptions(benDto.getDescriptions());
        benModel.setServices(benDto.getServices());


        return benModel;
    }
}
