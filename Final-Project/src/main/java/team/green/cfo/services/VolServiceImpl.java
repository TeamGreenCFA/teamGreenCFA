package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.green.cfo.daos.BenDao;
import team.green.cfo.daos.VolDao;
import team.green.cfo.models.VolModel;

import java.util.List;
import java.util.Optional;

@Service
public class VolServiceImpl implements VolService {


    private VolDao volDao;

    @Autowired
    public void setVolDao(VolDao volDao) {
        this.volDao = volDao;
    }

    @Override
    public VolModel get(Integer id) {
        return volDao.findById(id);
    }


    @Override
    public List<VolModel> getVolList() {
        return volDao.findAll();
    }

    @Override
    public VolModel saveOrUpdate(VolModel volModel) {
        return volDao.saveOrUpdate(volModel);
    }


    @Override
    public void deleteVon(Integer id) {
        volDao.delete(id);

    }


}
