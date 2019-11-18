package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.DAOFactory;
import lk.ijse.dep.pos.dao.DAOTypes;
import lk.ijse.dep.pos.dao.custom.QueryDAO;
import lk.ijse.dep.pos.db.HibernateUtil;
import lk.ijse.dep.pos.entity.CustomEntity;
import org.hibernate.Session;

class QueryDAOImplTest {

    public static void main(String[] args) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            QueryDAO dao = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
            dao.setSession(session);
            session.beginTransaction();
            CustomEntity orderInfo = dao.getOrderInfo(1);
            System.out.println(orderInfo.getOrderId());
            System.out.println(orderInfo.getCustomerId());
            System.out.println(orderInfo.getCustomerName());
            System.out.println(orderInfo.getOrderDate());
            session.getTransaction().commit();
        }

    }
}
