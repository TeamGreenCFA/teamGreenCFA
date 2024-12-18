package team.green.cfo.daos.jpa;

import org.springframework.stereotype.Repository;
import team.green.cfo.daos.VolDao;
import team.green.cfo.models.VolModel;
@Repository
public class JpaVolDao extends GenericJpaDao<VolModel> implements VolDao {


    public JpaVolDao() {
        super(VolModel.class);
    }
}
