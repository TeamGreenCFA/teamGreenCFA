package team.green.cfo.services;

import team.green.cfo.models.BenModel;

import java.util.List;

public interface BenService {

    List<BenModel> getBenList();

    BenModel get(Integer id);

    BenModel saveOrUpdate(BenModel benModel);

    void deleteBen(Integer id);


}
