package team.green.cfo.services;

import team.green.cfo.models.VolModel;

import java.util.List;

public interface VolService {

    List<VolModel> getVolList();

    VolModel get(Integer id);

    VolModel saveOrUpdate(VolModel volModel);

    void deleteVon(Integer id);


}
