package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import team.green.cfo.daos.BenDao;
import team.green.cfo.daos.VolDao;
import team.green.cfo.models.BenModel;

public class BenServiceImpl implements BenService{

    private BenDao benDao;
    private VolDao volDao;

    @Autowired
    public void setBenDao(BenDao benDao) {
        this.benDao = benDao;
    }
    @Autowired
    public void setVolDao(VolDao volDao) {
        this.volDao = volDao;
    }

    @Override
    public void createRequest() {

    }

    @Override
    public void getVolList() {

    }

    @Override
    public void getBenList() {

    }

    @Override
    public BenModel get(int id) {
        return benDao.findById(id);
    }
}
