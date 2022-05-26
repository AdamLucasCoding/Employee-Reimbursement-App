package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Manager;
import com.revature.util.HibernateUtil;

public class ManagerDAOImpl implements ManagerDAO{
	private static Logger log = Logger.getLogger(ManagerDAOImpl.class);
	
	@Override
	public int insert(Manager Manager) {
		log.info("adding Manager to database. Manager info: " + Manager);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(Manager);
		
		tx.commit();
		
		log.info("insert successful! New Manager id is " + pk);
		return pk; //return the auto-generated pk
	}

	@Override
	public Manager selectById(int managerId) {
		log.info("searching Manager by id: " + managerId);
		
		Session ses = HibernateUtil.getSession();
		
		Manager Manager = (Manager) ses.createNativeQuery("SELECT * FROM Managers WHERE Manager_id = " + managerId + "", Manager.class).getSingleResult();
		
		log.info("Search complete! Found: " + Manager);
		
		return Manager;
	}

	@Override
	public Manager selectByFirstName(String firstName) {
		log.info("searching Manager by firstName: " + firstName);
		
		Session ses = HibernateUtil.getSession();
		
		Manager Manager = (Manager) ses.createNativeQuery("SELECT * FROM Managers WHERE Manager_firstname = '" + firstName + "'", Manager.class).getSingleResult();
		
		log.info("Search complete! Found: " + Manager);
		
		return Manager;
	}

	@Override
	public List<Manager> selectAll() {
		log.info("getting all Managers from database....");
		Session ses = HibernateUtil.getSession();
		List<Manager> ManagerList = ses.createQuery("from Manager", Manager.class).list();
		log.info("Manager list retrieved! Size: " + ManagerList.size());
		return ManagerList;
	}

	@Override
	public boolean update(Manager Manager) {
		log.info("Updating Manager. Manager info: " + Manager);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.clear();
		
		ses.update(Manager);
		
		tx.commit();
		
		log.info("update complete");
		
		return true;
	}

	@Override
	public boolean delete(Manager Manager) {
		log.info("Deleting Manager. Manager info: " + Manager);
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.clear();
		
		ses.delete(Manager);
		
		tx.commit();
		
		log.info("deletion complete");
		
		return true;
	}

}