import java.util.*;
import java.util.regex.Pattern;
/**
 * Write a description of class Student here.
 * Stores all the student class data
 * @author Lakshmi Saketh
 * @version 03262018
 */

public class Student 
{

        private String studentID;
        private String studentName;
        Pattern digitPattern = Pattern.compile("\\d{6}"); 
        /**
         * Constructor for objects of class StudentClass
         */
        
        public Student()
        {
            
        }
        
        /**
         * Constructor for objects of class StudentClass
         */
        public Student(String studentID, String studentName)
        {
            this.studentID=studentID;
            this.studentName=studentName;
            
        }
    
        /**
         * accessor for studentName variable
         *
         * @return student name in String format
         */
        public String getStudentName()
        {
            return studentName;
        }
        

        /**
         * mutator for studentName variable
         *
         * @param studentName provided input student Name
         */
        public void setStudentName(String studentName)
        {
            this.studentName = studentName;
        }
        
        /**
         * accessor for studentID variable
         *
         * @return studentID in int format
         */
        public String getStudentID()
        {
            return studentID;
        }

        /**
         * mutator for studentID variable
         *
         * @param studentID provided input student ID
         */
        public void setStudentID(String studentID) 
        {
            this.studentID = studentID;
        }
    
        public boolean isValid(String studentID)
        {
            boolean result = false;
            
            if(digitPattern.matcher(studentID).matches())
            {
                result =true;
            }
            return result;
        }
        
        public boolean idExists(String studentID)
        {
            boolean result = false;
            
            
            return result;
        }
}

