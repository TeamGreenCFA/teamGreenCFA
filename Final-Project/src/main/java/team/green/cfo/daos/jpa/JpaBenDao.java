package team.green.cfo.daos.jpa;

import org.springframework.stereotype.Repository;
import team.green.cfo.daos.BenDao;
import team.green.cfo.models.BenModel;
<<<<<<< HEAD
=======

>>>>>>> 2aa2ef72ccb4a51d1220060b446e511cd724189a
@Repository
public class JpaBenDao extends GenericJpaDao<BenModel> implements BenDao {


    public JpaBenDao() {
        super(BenModel.class);
    }
}
