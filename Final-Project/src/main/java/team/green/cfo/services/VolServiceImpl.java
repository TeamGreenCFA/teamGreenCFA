package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.green.cfo.daos.jpa.JpaVolDao;
import team.green.cfo.models.VolModel;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VolServiceImpl implements VolService {


    private JpaVolDao volDao;

    @Autowired
    public void setVolDao(JpaVolDao volDao) {
        this.volDao = volDao;
    }

    @Transactional
    @Override
    public VolModel get(Integer id) {
        return volDao.findById(id);
    }

    @Transactional
    @Override
    public List<VolModel> getVolList() {
        return volDao.findAll();
    }

    @Transactional
    @Override
    public VolModel saveOrUpdate(VolModel volModel) {
        return volDao.saveOrUpdate(volModel);
    }

    @Transactional
    @Override
    public void deleteVon(Integer id) {
        volDao.delete(id);

    }


}
