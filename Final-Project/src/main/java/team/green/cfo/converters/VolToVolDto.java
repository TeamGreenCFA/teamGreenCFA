package team.green.cfo.converters;

import org.springframework.stereotype.Component;
import team.green.cfo.command.VolDto;
import team.green.cfo.models.VolModel;
@Component
public class VolToVolDto extends AbstractConverter<VolModel, VolDto> {

    public VolDto convert(VolModel volModel) {

        VolDto volDto = new VolDto();

        volDto.setId(volModel.getId());
        volDto.setFirstName(volModel.getFirstName());
        volDto.setLastName(volModel.getLastName());
        volDto.setEmail(volModel.getEmail());
        volDto.setPhone(volModel.getPhone());
        volDto.setAddress(volModel.getAddress());
        volDto.setDescriptions(volModel.getDescriptions());
        volDto.setAge(volModel.getAge());
        volDto.setServices(volModel.getServices());

        return volDto;
    }
}
