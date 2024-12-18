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
}
