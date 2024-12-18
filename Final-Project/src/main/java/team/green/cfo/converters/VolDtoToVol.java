package team.green.cfo.converters;

import org.springframework.core.convert.converter.Converter;
import team.green.cfo.command.VolDto;
import team.green.cfo.models.VolModel;
import team.green.cfo.services.VolService;

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

        return volModel;
    }
}
