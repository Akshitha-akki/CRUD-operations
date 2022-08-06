package com.net.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.net.hibernate.model.Student;
import com.net.hibernate.util.HibernateUtil;

public class StudentDao {

	public void saveStudent(Student student)
	{
		Transaction trans = null ;
		try 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(student);
			trans.commit();
		}
		catch (Exception e) 
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	public void updateStudent(String fname ,int id )
	{
		Transaction trans = null;
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q= session.createQuery("Update Student set fname=:fname where id=:id");
			q.setParameter("fname",fname);
			q.setParameter("id", id);
			int i = q.executeUpdate();
			System.out.println("*********"+i);
			if(i>0)
			{
				System.out.println("Update successfully!");
			}
			trans.commit();
		}
		catch(Exception e)
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id)
	{
		Transaction trans = null;
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q= session.createQuery("delete from Student where id=:id");
			q.setParameter("id", id);
			int i = q.executeUpdate();
			System.out.println("*********"+i);
			if(i>0)
			{
				System.out.println("Delete successfully!");
			}
			trans.commit();
		}
		catch(Exception e)
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	public void totalStudentdetails()
	{
		Transaction trans = null;
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q= session.createQuery("from Student");
			List<Student> student = q.list();
			for(Student s : student)
			{
				System.out.println("Id : "+s.getId()+"\nName : "+s.getFname()+" "+s.getLname());
			}
			 
			trans.commit();
		}
		catch(Exception e)
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	public void selectStudent(int id)
	{
		Transaction trans = null;
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q= session.createQuery("from Student where id=:id");
			q.setParameter("id",id);
			List<Student> student = q.list();
			for(Student s : student)
			{
				System.out.println("Id : "+s.getId()+"\nName : "+s.getFname()+" "+s.getLname());
			}
			trans.commit();
		}
		catch(Exception e)
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
	public void sortStudent()
	{
		Transaction trans = null;
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Query q= session.createQuery("from Student orderby ");
			List<Student> student = q.list();
			for(Student s : student)
			{
				System.out.println("Id : "+s.getId()+"\nName : "+s.getFname()+" "+s.getLname());
			}
			trans.commit();
		}
		catch(Exception e)
		{
			if(trans != null)
			{
				trans.rollback();
			}
			e.printStackTrace();
		}
	}
}
