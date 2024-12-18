package team.green.cfo.services;

import team.green.cfo.models.BenModel;
import team.green.cfo.models.VolModel;

public interface VolService {

    void createRequest();

    void getVolList();

    void getBenList();
    VolModel get(int id);

}
