package team.green.cfo.daos.jpa;

import team.green.cfo.daos.BenDao;
import team.green.cfo.models.BenModel;

public class JpaBenDao extends GenericJpaDao<BenModel> implements BenDao {


    public JpaBenDao() {
        super(BenModel.class);
    }
}
