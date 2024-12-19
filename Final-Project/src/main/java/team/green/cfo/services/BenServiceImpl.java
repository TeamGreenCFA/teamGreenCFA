package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import team.green.cfo.daos.jpa.JpaBenDao;
import team.green.cfo.models.BenModel;


import java.util.List;

@Service
public class BenServiceImpl implements BenService {

    private JpaBenDao jpaBenDao;


    @Autowired
    public void setBenDao(JpaBenDao jpaBenDao) {
        this.jpaBenDao = jpaBenDao;
    }

    @Transactional
    @Override
    public BenModel get(Integer id) {
        return jpaBenDao.findById(id);
    }
    @Transactional
    @Override
    public List<BenModel> getBenList() {
        return jpaBenDao.findAll();
    }
    @Transactional
    @Override
    public BenModel saveOrUpdate(BenModel benModel) {
        return jpaBenDao.saveOrUpdate(benModel);
    }

    @Transactional
    @Override
    public void deleteBen(Integer id) {
        jpaBenDao.delete(id);

    }
}
