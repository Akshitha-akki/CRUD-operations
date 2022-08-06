package com.hibernate.operation.crud.operation;

import com.net.hibernate.dao.StudentDao;
import com.net.hibernate.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        StudentDao s = new StudentDao();
      /*  Student s1 = new Student("S", "Akshitha");
        Student s2 = new Student("A","Deekshith");
        Student s3 = new Student("A", "Money");
        //Inserting the records
        s.saveStudent(s1);
        s.saveStudent(s2);
        s.saveStudent(s3);*/
        
        //Updating records
        //s.updateStudent("Alampally",2);
        
        //Delete
        //s.deleteStudent(3);    
        
        //Student details
        //s.totalStudentdetails();
        
        //search with id
        //s.selectStudent(2);
        
        //sort
        s.sortStudent();
        
    }
}
