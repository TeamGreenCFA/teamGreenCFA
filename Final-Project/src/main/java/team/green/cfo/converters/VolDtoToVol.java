package team.green.cfo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import team.green.cfo.command.VolDto;
import team.green.cfo.models.VolModel;
import team.green.cfo.services.VolService;
@Component
public class VolDtoToVol implements Converter<VolDto, VolModel> {

    private VolService volService;

    public void setVolService(VolService volService) {
        this.volService = volService;
    }

    public VolModel convert(VolDto volDto) {
        VolModel volModel = (volDto.getId() != null ? volService.get(volDto.getId()) : new VolModel());

        volModel.setFirstName(volDto.getFirstName());
        volModel.setLastName(volDto.getLastName());
        volModel.setEmail(volDto.getEmail());
        volModel.setPhone(volDto.getPhone());
        volModel.setAddress(volDto.getAddress());
        volModel.setDescriptions(volDto.getDescriptions());
        volModel.setAge(volDto.getAge());
        volModel.setServices(volDto.getServices());

        return volModel;
    }
}
