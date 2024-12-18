package team.green.cfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.green.cfo.daos.BenDao;
import team.green.cfo.daos.VolDao;
import team.green.cfo.models.BenModel;

import java.util.List;

@Service
public class BenServiceImpl implements BenService {

    private BenDao benDao;


    @Autowired
    public void setBenDao(BenDao benDao) {
        this.benDao = benDao;
    }


    @Override
    public BenModel get(Integer id) {
        return benDao.findById(id);
    }

    @Override
    public List<BenModel> getBenList() {
        return benDao.findAll();
    }


    @Override
    public void createBenAccount() {

    }

    @Override
    public BenModel saveOrUpdate(BenModel benModel) {
        return benDao.saveOrUpdate(benModel);
    }


    @Override
    public void deleteBen(Integer id) {
        benDao.delete(id);

    }
}
