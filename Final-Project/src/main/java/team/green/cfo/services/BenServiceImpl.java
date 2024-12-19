package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.green.cfo.daos.jpa.JpaBenDao;
import team.green.cfo.models.BenModel;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class BenServiceImpl implements BenService {

    private JpaBenDao jpaBenDao;


    @Autowired
    public void setBenDao(JpaBenDao jpaBenDao) {
        this.jpaBenDao = jpaBenDao;
    }


    @Override
    @Transactional
    public BenModel get(Integer id) {
        return jpaBenDao.findById(id);
    }

    @Override
    @Transactional
    public List<BenModel> getBenList() {
        return jpaBenDao.findAll();
    }

    @Override
    @Transactional
    public BenModel saveOrUpdate(BenModel benModel) {
        return jpaBenDao.saveOrUpdate(benModel);
    }


    @Override
    @Transactional
    public void deleteBen(Integer id) {
        jpaBenDao.delete(id);
    }
}
