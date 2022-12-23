package responsitory;

import com.mysql.cj.Query;
import com.mysql.cj.Session;
import entity.Department;
import utils.HibernateUtils;

import java.util.List;

public class DepartmentResponsitory {
    private HibernateUtils hibernateUtils;
    public DepartmentResponsitory(){
        hibernateUtils = HibernateUtils.getInstance()
    }
    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments(){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department");
            return query.list();
        }finally {
        if(session != null)
            session.close();
        }
        }
    }
