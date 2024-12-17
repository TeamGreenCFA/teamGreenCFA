package team.green.cfo.daos.jpa;

import team.green.cfo.daos.VolDao;
import team.green.cfo.models.VolModel;

public class JpaVolDao extends GenericJpaDao<VolModel> implements VolDao {


    public JpaVolDao() {
        super(VolModel.class);
    }
}
