package team.green.cfo.converters;

import team.green.cfo.command.VolDto;
import team.green.cfo.models.VolModel;

public class VolToVolDto extends AbstractConverter<VolModel, VolDto> {

    public VolDto convert(VolModel volModel) {

        VolDto volDto = new VolDto();

        volDto.setId(volModel.getId());
        volDto.setFirstName(volModel.getFirstName());
        volDto.setLastName(volModel.getLastName());
        volDto.setEmail(volModel.getEmail());
        volDto.setPhone(volModel.getPhone());

        return volDto;
    }
}
