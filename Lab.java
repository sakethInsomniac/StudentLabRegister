
/**
 * Write a description of class Lab here.
 * Stores all the Lab Class Data get and set methods
 * @author LakshmiSaketh
 * @version 03262018
 */
import java.util.*;

public class Lab 
{
    //Variable Declaration
    private ArrayList<Student> studentList=new ArrayList<Student>();
    private String subjCode;
    private String roomNo;
    private int registration=0;
    private int capacity;
    private String time;
    private int labNo;
    private String tutorName;
    
    
    
     /**
     * Constructor for objects of class Lab
     */
    public Lab() 
    {
        
    }
    
    /**
     * Parameterized Constructor for objects of class Lab Class
     */
    public Lab(String tutorName,String roomNo,String time,String subjCode,int labNo,int capacity)
    {
        this.roomNo=roomNo;
        this.tutorName=tutorName;
        this.time=time;
        this.subjCode=subjCode;
        this.labNo=labNo;
        this.capacity=capacity;
    
    }
        /**
         * accessor for getRegistration variable
         *
         * @return student name in String format
         */
       public int getRegistration()
        {
            return registration;
        }
        
        /**
         * mutator for setregistration variable
         *
         * @param registration  provided in int format
         */
        public void setRegistration(int registration)
        {
             this.registration=registration;
        }
    
        /**
         * accessor for time variable
         *
         * @return time in String format
         */
        public String getTime()
        {
            return time;
        }
        
        /**
         * mutator for setTime variable
         *
         * @param time provided input String
         */
        public void setTime(String time) 
        {
            this.time = time;
        }
        
        /**
         * accessor for labNo variable
         *
         * @return getLabNo in int format
         */
        public int getLabNo()
        {
            return labNo;
        }

        /**
         * mutator for labNo variable
         *
         * @param getLabNo provided input time
         */
        public void setLabNo(int labNo) 
        {
            this.labNo = labNo;
        }
        
        /**
         * accessor for roomNo variable
         *
         * @return roomNo in int format
         */
        public String getRoomNo()
        {
            return roomNo;
        }
    

        /**
         * mutator for labNo variable
         *
         * @param getLabNo provided int format
         */
        public void setRoomNo(String roomNo) 
        {
            this.roomNo = roomNo;
        }
        
        /**
         * accessor for tutuorName variable
         *
         * @return tutuorName in String format
         */
        public String getTutorName()
        {
            return tutorName;
        }


        /**
         * mutator for tutuorName variable
         *
         * @param getLabNo provided String format
         */
        public void setTutorName(String tutorName) 
        {
            this.tutorName = tutorName;
        }
      
        /**
         * accessor for capacity variable
         *
         * @return cpapcity in int format
         */
        public int getCapacity()
        {
            return capacity;
        }
    

        /**
         * mutator for capacity variable
         *
         * @param capacity provided input setCapacity
         */
        public void setCapacity(int capacity) 
        {
            this.capacity = capacity;
        }
    
        /**
         * accessor for generating participant list
         */
        public ArrayList<Student> getStudentsRegistered()
        {
            return studentList;
        }
    
        /**
         * mutator to access participant list
         *
         * @param participantList user provided data for participant list
         */
        public void setStudentsRegistered(ArrayList<Student> studentList)
        {
            this.studentList = studentList;
        }
       
        /**
         * accessor for SubjCode variable
         *
         * @return subjCode in String format
         */
        public String getSubjCode()
        {
            return subjCode;
        }
    
        /**
         * mutator for subjCode variable
         *
         * @param subjCode provided input setSubjCode
         */
        public void setSubjCode(String subjCode) 
        {
            this.subjCode = subjCode;
	    }

    
}
