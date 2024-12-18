package team.green.cfo.converters;

import org.springframework.core.convert.converter.Converter;
import team.green.cfo.command.BenDto;
import team.green.cfo.models.BenModel;
import team.green.cfo.services.BenService;

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

        return benModel;
    }
}
