package team.green.cfo.converters;

import org.springframework.stereotype.Component;
import team.green.cfo.command.BenDto;
import team.green.cfo.models.BenModel;
@Component
public class BenToBenDto extends AbstractConverter<BenModel, BenDto> {

    public BenDto convert(BenModel benModel) {

        BenDto benDto = new BenDto();

        benDto.setId(benModel.getId());
        benDto.setFirstName(benModel.getFirstName());
        benDto.setLastName(benModel.getLastName());
        benDto.setEmail(benModel.getEmail());
        benDto.setPhone(benModel.getPhone());
        benDto.setAddress(benModel.getAddress());
        benDto.setAge(benModel.getAge());
        benDto.setDescriptions(benModel.getDescriptions());
        benDto.setServices(benModel.getServices());

        return benDto;
    }
}
