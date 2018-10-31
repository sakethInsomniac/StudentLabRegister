
/**
 * Write a description of class LabMaster here.
 *
 * @author Lakshmi Saketh
 * @version 03262018
 */
import java.util.ArrayList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LabMaster
{
	
	private ArrayList<Lab> labArrayList =new ArrayList<Lab>();
	private static final String PATTERNTIME = "KK:mm a";
	
	/**
     * Constructor for objects of class LabMaster
     */
	public LabMaster()
	{
		
	}
	
	/**
     * Method to add a lab object to list of lablist
     * 
     * @param lab object of class LabClass
     * @return boolean
     */
    public boolean addLab(Lab lb) 
    {   	
        return labArrayList.add(lb);
    }
    
    /**
     * Method to getoneSubjLabArray  to list of labArrayList
     * 
     * @param varsubCode object of string DataType
     * @return arrayList of Lab Class
     */
    public ArrayList<Lab> getOneSubjLabArray(String varSubCode) 
    {
    	ArrayList<Lab> labFullList = new ArrayList<Lab>();
        for (Lab labObj : labArrayList) 
        {
            if (labObj.getSubjCode().equals(varSubCode) ) 
            {
            	labFullList.add(labObj);
            }
        }
        return  labFullList;
    }
    
    /**
     * Method to add a lab object to list of labArrayList
     * 
     * @param varLabNo of int and varSubCode of String format
     * @return Lab class Object
     */
    public Lab getOneSubjLab(int varLabNo,String varSubCode) 
    {
    	
        for (Lab labObj : labArrayList) 
        {
            if (labObj.getSubjCode().equals(varSubCode) && labObj.getLabNo()==varLabNo) 
            {
            	return labObj;
            }
        }
        return null ;
    }
    
    /**
     * Method to add a lab object to list of labArrayList for delete based on zero registrations
     * 
     * @param varLabNo of int and varSubCode of String format
     * @return Lab class Object
     */
    public Lab getOneSubjLabDel(int varLabNo,String varSubCode) 
    {
    	
        for (Lab labObj : labArrayList) 
        {
            if (labObj.getSubjCode().equals(varSubCode) && labObj.getLabNo()==varLabNo && labObj.getRegistration()==0) 
            {
            	return labObj;
            }
        }
        return null ;
    }
    
    /**
     * Method to Delete a lab object to list of lablist
     * 
     * @param lab object of class LabClass
     * @return boolean
     */
    public boolean DeleteLab(Lab lb) 
    {
        return labArrayList.remove(lb);  
    }
    
    
    /**
     * Method to getFullLabs from labArrayList
     * 
     * @param String varSubCode
     * @return ArrayList of lab objects
     */
    public ArrayList<Lab> getFullLabs(String varSubCode) 
    {
    	ArrayList<Lab> labFullList = new ArrayList<Lab>();    
        for (Lab labObj : labArrayList) 
        {        	
            if (labObj.getSubjCode().equals(varSubCode) && labObj.getCapacity()==labObj.getRegistration()) 
            {
            	labFullList.add(labObj);
            }
        }
        return  labFullList;
    }
    
    /**
     * Method to getAvailableLabs object to list of labArrayList
     * 
     * @param varSubCode of String format
     * @return ArrayList of lab Objects
     */
    public ArrayList<Lab> getAvailableLabs(String varSubCode) 
    {
    	ArrayList<Lab> labFullList = new ArrayList<Lab>();    
        for (Lab labObj : labArrayList) 
        {        	
            if (labObj.getSubjCode().equals(varSubCode) && labObj.getCapacity() > labObj.getRegistration()) 
            {
            	labFullList.add(labObj);
            }
        }
        return  labFullList;
    }
    
    /**
     * Method to get all the labs  code from labArrayList
     * 
     * @param 
     * @return ArrayList of Lab objects
     */
    public ArrayList<Lab> getTotalLabs() 
    {
    	ArrayList<Lab> labFullList = new ArrayList<Lab>();    
        for (Lab labObj : labArrayList) 
        {        	
            if (labObj.getCapacity() > labObj.getRegistration()) 
            {
            	labFullList.add(labObj);
            }
        }
        return  labFullList;
    }
    
    /**
     * Method to registerStudent to studentClass
     * 
     * @param lab object, student Obj
     * @return boolean
     */
    public boolean registerStudent(Lab lbObj, Student stdntObj) 
    {
    	ArrayList<Student> studentList = lbObj.getStudentsRegistered();
    	boolean result ;
    	for (Student student : studentList) 
        {
        	
            if (studentList.contains(student.getStudentID())) 
            {
            	System.out.println(" Student: "+student.getStudentID()+" Already registered in the Lab ");
            	break;
            }

        }
 
        if (studentList.size() < lbObj.getCapacity() ) 
        		
        {
             result = lbObj.getStudentsRegistered().add(stdntObj);
            if (result) 
            {
            	int count=lbObj.getRegistration() + 1;
                lbObj.setRegistration(count);
                System.out.println("Student registered successfully");
            } 
            else 
            {
            	System.out.println("Student Registration Failed ");
            }
        } 
        else 
        {
        	System.out.println("Registrations closed for the lab");
        	 
        }
        
   
    return true;

    }
    
    /**
     * Method to print the table
     * 
     * @param lab Array list objects
     * @return 
     * @throws ParseException 
     */
    public void PrintTable(ArrayList<Lab> labArrayList) throws ParseException 
    {
    	
      	 System.out.println("============================================================================================");
   	     System.out.printf("%10s %10s %10s %10s %11s %10s %15s", "Subject Code", "#Lab Number", "Room Nuumber", "Time Slot","Tutor Name", "Capacity","Registration");
   	     System.out.println();
   	     System.out.println("===========================================================================================");
           for (Lab labObj : labArrayList) 
           {
          	 
       	   
       	     System.out.format("%5s %12d %10s %15s %12s %11d %12d", labObj.getSubjCode(), labObj.getLabNo(), labObj.getRoomNo(), StringToDate(labObj.getTime()),labObj.getTutorName(), labObj.getCapacity(),labObj.getRegistration());
       	        System.out.println();
       	    
       	    System.out.println("========================================================================================="); 
           }
    } 
    
    
    /**
     * Method to delete student object to list of studentList
     * 
     * @param removeListLab ArrayList of lab ,studentID of int dataType
     * @return boolean
     */
    public boolean deleteStudent(ArrayList<Lab> removeListLab, String studentID) 
    {
    	ArrayList<Student> removeList = new ArrayList<Student>();
    	 boolean result=false;
    	
    	
    	for(Lab lbObj : removeListLab)
    	{
    	for (Student student : lbObj.getStudentsRegistered()) 
    	{
            if (student.getStudentID().equals(studentID))
            {
            	result = lbObj.getStudentsRegistered().remove(student);
            	break;
            }
        }
    	
           
            if (result) 
            {
            	System.out.println("StudentID has been successfully removed from the Lab");
            	lbObj.setRegistration(lbObj.getRegistration()-1);
            } else 
            {
            	System.out.println("Error occurred while Student removal. Please try again");
            }
    	
    	}
        
        return  true;
    }    

    /**
     * Method to add a lab object to list of lablist
     * 
     * @param lab object of class LabClass
     * @return boolean
     */
    public ArrayList<Lab> registeredLabs(String studentID) 
    {
    	ArrayList<Lab> registerLabList = new ArrayList<Lab>();
        for (Lab labObj : labArrayList) 
        {
           if(labObj.getStudentsRegistered()!=null)
           {
        	   for (int i=0; i<labObj.getStudentsRegistered().size(); i++)
        	   {
        		   System.out.println(labObj.getStudentsRegistered().get(i).getStudentID());
        	        String result=labObj.getStudentsRegistered().get(i).getStudentID();
        	        if(result.equals(studentID))
        	        {
        	        	registerLabList.add(labObj);
        	        }
        	      
        	   }
        	 }       	
         }   
        return  registerLabList;
    }
    
    /**
     * Method to remove student from oneLab
     * 
     * @param student ID of string format, labremove of Lab Object
     * @return boolean
     */
    public boolean removeStudentOneLab(String studentID, Lab labRemove)
    {
    	ArrayList<Student> studentRemoveList = new ArrayList<Student>();
    	for (Student student : labRemove.getStudentsRegistered()) 
    	{
            if (student.getStudentID().equals(studentID))
            {
                studentRemoveList.add(student);
            }
        }
    	
            boolean status = labRemove.getStudentsRegistered().removeAll(studentRemoveList);
            if (status) 
            {
            	System.out.println("StudentID has been successfully removed from the Lab");
            	labRemove.setRegistration(labRemove.getRegistration()-1);
            } else 
            {
            	System.out.println("Error occurred while employee removal. Please try again");
            }
    	
        
        
        return  true;
    }
    
    /**
     * Method to get the studentInfo to list of studentList
     * 
     * @param String studentID
     * @return Student Class Object
     */
    public Student getStudentInfo(String studentID) 
    {
    	String id;
        for (Lab labInfo : labArrayList) 
        {
        	
           if(labInfo.getStudentsRegistered()!=null)
           {
        	   for (int i=0; i<labInfo.getStudentsRegistered().size(); i++)
        	   {
        	       id =labInfo.getStudentsRegistered().get(i).getStudentID();
        	        if(id.equals(studentID))
        	        {
        	        	String stdntName=labInfo.getStudentsRegistered().get(i).getStudentName();
        	        	return new Student(id,stdntName);
        	        }  
        	    }
           }

        }
        return  null;
    }
    
    /**
     * Converts String to Date format
     *
     * @param input varDateString
     * @return converted string to Date
     * 
     */
    public static String StringToDate(String varDateString) throws ParseException
    {
    	DateFormat inputFormat = new SimpleDateFormat("HH:mm");
        DateFormat outputformat = new SimpleDateFormat(PATTERNTIME);
        return outputformat.format(inputFormat.parse(varDateString));
    }

}
