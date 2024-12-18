package team.green.cfo.services;

import team.green.cfo.models.BenModel;

public interface BenService {

    void createRequest();

    void getVolList();

    void getBenList();
    BenModel get(int id);



}
