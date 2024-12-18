package team.green.cfo.daos.jpa;

import org.springframework.stereotype.Repository;
import team.green.cfo.daos.BenDao;
import team.green.cfo.models.BenModel;
@Repository
public class JpaBenDao extends GenericJpaDao<BenModel> implements BenDao {


    public JpaBenDao() {
        super(BenModel.class);
    }
}
