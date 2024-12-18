package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import team.green.cfo.daos.BenDao;
import team.green.cfo.daos.VolDao;
import team.green.cfo.models.VolModel;

public class VolServiceImpl implements VolService {

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
    public VolModel get(int id) {
        return volDao.findById(id);
    }
}
