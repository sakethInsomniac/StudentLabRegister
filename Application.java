
/**
 * Write a description of class Application here.
 *
 * @author Lakshmi Saketh
 * @version 03262018
 */
import java.text.ParseException;
import java.util.*;
public class Application {
	static LabMaster lab=null;
	
	/**
     * Parameterized Constructor for Application  class
     * 
     * 
     */
	public Application(LabMaster labMaster) 
    {
        lab = labMaster;
    }
	
	/**
     * Constructor for Application class
     * 
     * 
     */
	public Application()
	{
		
	}
	
	public static void main(String[] args)
    {
		LabMaster labMaster = new LabMaster();
        Application app= new Application(labMaster);
	try 
    {
        while (true) 
        {
            switch (displayMenu()) 
            {
                case 1: addLabMethod();
                        break;
                        
                case 2: removeLabMethod();
                        break;
             
                case 3: totalLabsMethod();
                        break;
                
                case 4: registerStudentMethod();
                        break;
                
                case 5: removeStudentMethod();
                        break;
                case 6: LabBookedByStudentMethod();
                		break;
                case 7: ChangeLabByStudentMethod();
        				break;
                
                case 8: System.out.println("Leaving Application"); return;
                
                default:System.out.println("Enter Valid Opt");
                        break;
                
            }
        }
    } 
    catch (Exception e) 
    {
        System.out.println("Something wrong !! Exception occured !! Please check your selection");
    }
    
    
}

	 /**
     * displayMenu Method
     *
     * return input of int format
     * 
     * 
     */ 	
public static  int displayMenu() 
{
	System.out.println(" =============SwinBurne Lab Booking System==============");
    System.out.println(" 1 . Add Lab ");
    System.out.println(" 2 . Remove Lab");
    System.out.println(" 3 . Total Labs");
    System.out.println(" 4 . Register student");
    System.out.println(" 5 . Remove Student");
    System.out.println(" 6 . List Lab by student");
    System.out.println(" 7 . Change Lab of Student ");
    System.out.println(" 8 . Exit");
    System.out.println(" =======================================================");
    System.out.println();
    System.out.print("Please enter your choice : ");

    Scanner si = new Scanner(System.in);
    int input = si.nextInt();
    System.out.println();
    return input;

}

/**
 * addLabMethod helps to add the lab to the subject
 *
 * @values subjCode,tutorName,roomNo,labNo,time,capacity
 * 
 * 
 */ 

public static void addLabMethod()
{
	try 
	{
	//Code here
	Scanner input = new Scanner(System.in);
	Scanner input1 = new Scanner(System.in);
	System.out.println("Please Enter Subject code for Lab ");
	String varSubjCode=input.nextLine();
	System.out.println("Please Enter tutorName for Lab ");
	String varTutorName=input.nextLine();
	System.out.println("Please Enter Lab Number for Lab ");
	int varLabNo=input.nextInt();
	System.out.println("Please Enter Room Number for Lab ");
	String varRoomNo=input1.nextLine();
	System.out.println("Please Enter Time for Lab in hh:mm Am/pm Format ");
	String varTime=input1.nextLine();
	System.out.println("Please Enter Capacity for Lab ");
	int varCapacity=input1.nextInt();
	
	if (!varSubjCode.trim().equals("") && !varTutorName.trim().equals("") && !varRoomNo.trim().equals("") && varLabNo!=0 && !varTime.trim().equals("")  &&  varCapacity!=0 ) 
	{
	
		if(lab.addLab(new Lab(varTutorName,varRoomNo,varTime,varSubjCode,varLabNo,varCapacity)))
		{
			System.out.println("New Lab Added successfully for the SubjectCode: "+varSubjCode);
		}
		else
		{
			System.out.println("System is busy please try again");	
		}
		
	}
	else
	{
		System.out.println("Wrong Inputs please try again with valid inputs");
	}
	}
	catch (Exception ex)
	{
		System.out.println(ex);
	}
	
}
	
/**
 * removelab Method helps to remove the lab under the subject
 *
 * @param
 * 
 * @return
 */ 

public static void removeLabMethod()
{
	int varLabNo;
	String varSubCode;
	Scanner input = new Scanner(System.in);
	
    try 
    {
    System.out.print("Please enter the Subject Code");
    varSubCode = input.nextLine();
    ArrayList<Lab> oneLabList=lab.getOneSubjLabArray(varSubCode);
    if (oneLabList.size() != 0) 
    {
   	 System.out.println("============================Available Labs Under :"+varSubCode+"====================================");
   	 lab.PrintTable(oneLabList);
        System.out.print("Please enter the Lab Number to Delete");
        varLabNo=input.nextInt();
        if ( varLabNo!=0 && !varSubCode.trim().isEmpty() ) 
        {
            Lab delLab = lab.getOneSubjLabDel(varLabNo,varSubCode);
            if (delLab!=null) 
            {
                 if(lab.DeleteLab(delLab))
                 {
                	  System.out.println("Lab removed successfully under the subject:"+varSubCode);
                 }
                	 
                 else
                 {
                	 System.out.println("System is busy please try again ");
                 }
            } 
            else 
            {
                System.out.println("Lab has registrations or lab doesnt exist");
               
            }
        } 
        else 
        {
            System.out.println("No labs in List");   
        }
      }
    
    else 
    {
        System.out.println(" Lab dont exist \n"); 
    }
   }
    
    catch(Exception ex)
    {
        System.out.println("Exception:" + ex);
		
	} 
}


/**
 * totalLabsMethod Method helps to list the labs under the subject based on the userinput
 *
 * @param
 * 
 * @return
 */ 

public static void totalLabsMethod()
{
	
	Scanner input = new Scanner(System.in);
	try 
	{
		 System.out.println("Enter the subject Code to check Labs");
		String varSubCode=input.nextLine();
	 ArrayList<Lab> oneLabList=lab.getAvailableLabs(varSubCode);
	 
	 if(oneLabList !=null)   
	 {
	 if (oneLabList.size() != 0) 
	    {
	   	 System.out.println("============================Available Labs Under :"+varSubCode+"====================================");
	   	 lab.PrintTable(oneLabList);
	    }
	    else 
	    {
	    	System.out.println("All Labs are full Registrations Closed"); 
	    }
	    
	    oneLabList=lab.getFullLabs(varSubCode);
	    if(oneLabList.size()!=0)
	    {	    	
	    	System.out.println("============================Full Labs Under : "+varSubCode+"====================================");
		   	 lab.PrintTable(oneLabList);
	    }
	    else
	    {
	    	 System.out.println("No Lab is Full.... Registrations Open.....\n");
	    }
	 }
	 else
	 {
		 System.out.println("No Lab is there under this subject.....\n"); 
	 }
	    
	}
	    catch(Exception ex)
	    {
	    	System.out.println("Exception:" + ex);
	    }
	
}

/**
 * registerStudentMethod Method helps to register the lab under the lab
 *
 * @param
 * 
 * @return
 * @throws ParseException 
 */ 

public static void registerStudentMethod() throws ParseException
{
	 ArrayList<Lab> lbList = lab.getTotalLabs();
	 if (lbList.size() != 0) 
	  {
	   	System.out.println("============================Available Labs Details====================================");
	   	lab.PrintTable(lbList);
	   	
	   	System.out.println("Enter the subject Code");
        Scanner sc = new Scanner(System.in);
        String subjCode = sc.nextLine();
        System.out.println("Enter the Lab No");
        int labNo = sc.nextInt();
        
        Student studentObj = new Student();
        Lab labObj =new Lab();
        System.out.println("Please Enter details of Student to enroll in the Lab");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter Student ID");
        String stdntID = sc1.nextLine();
        studentObj.setStudentID(stdntID);
        System.out.println("Enter Student Name");
        String stdntName = sc1.nextLine();
        studentObj.setStudentName(stdntName); 
        Lab lbObj=new Lab();
        if(!subjCode.trim().equals("") && labNo!=0 && !stdntID.trim().equals("") && !stdntName.trim().equals(""))
        {
      
        lbObj=lab.getOneSubjLab(labNo,subjCode);
        boolean result=lab.registerStudent(lbObj, studentObj);
        }
        else
        {
       	 System.out.println("Wrong inputs");
        }

	  }
	    else 
	    {
	    	System.out.println("All Labs are full Registrations Closed"); 
	    }
	  
}

/**
 * removeStudentMethod Method helps to remove the lab under the subject
 *
 * @param
 * 
 * @return
 * @throws ParseException 
 */ 

public static void removeStudentMethod() throws ParseException
{
	String studentID;
	boolean status;
	System.out.println("Please Enter the student ID");
    Scanner sc = new Scanner(System.in);
    studentID = sc.nextLine();
    if(!studentID.trim().equals(""))
    {
    ArrayList<Lab> removeLabList = lab.registeredLabs(studentID);
   
    
    if (removeLabList !=null) 
    {
   	lab.PrintTable(removeLabList);
   	 	
        status=lab.deleteStudent(removeLabList, studentID);
        if(status)
        {
        System.out.println(" Student Deleted from the Above Labs \n"); 
        }
        else
        {
        	System.out.println(" Error Occured \n"); 
        }
        
    } 
    else 
    {
        System.out.println(" Available labs List Empty \n"); 
        
    }
    }
    else {
    	System.out.println(" Provide Valid Inputs\n"); 
    	
    }
}

/**
 * changeLabbyStudentMethod Method helps to change the lab under the subject
 *
 * @param
 * 
 * @return
 * @throws ParseException 
 */ 

public static void ChangeLabByStudentMethod() throws ParseException
{
	String studentID;
	boolean status;
	System.out.println("Please Enter the student ID");
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    studentID = input.nextLine();
    ArrayList<Lab> changeList = lab.registeredLabs(studentID);
    Lab labChange= new Lab();
  
    if (changeList.size() != 0) 
    {
    	lab.PrintTable(changeList);
    	
    	Student studentObj=lab.getStudentInfo(studentID);
        System.out.println("Please Enter the subj Code");
        String varSubCode=input.nextLine();
        System.out.println("Please Enter the labNo Code");
        int varLabNo=input.nextInt();
        labChange  = lab.getOneSubjLab(varLabNo, varSubCode);
        boolean result=lab.removeStudentOneLab(studentID, labChange);
        System.out.println("Please Enter the New subj Code");
        varSubCode=input2.nextLine();
        System.out.println("Please Enter the New  labNo Code");
         varLabNo=input2.nextInt();
         
         if(!varSubCode.trim().equals("") && varLabNo!=0 )
         {
       
        labChange=lab.getOneSubjLab(varLabNo,varSubCode);
        
        status=lab.registerStudent(labChange, studentObj);
         }
         else {
        	 System.out.println("Please enter the proper values");
         }
    }
    else {
    	System.out.println("No ID exists");
    }
	
}

/**
 * LabBookedByStudent Method helps to list the lab under the student
 *
 * @param
 * 
 * @return
 * @throws ParseException 
 */ 
public static void LabBookedByStudentMethod() throws ParseException
{
	String studentID;
	boolean status;
	System.out.println("Please Enter the student ID");
    Scanner sc = new Scanner(System.in);
    studentID = sc.nextLine();
    if(!studentID.trim().equals(""))
    {
    ArrayList<Lab> studentLabList = lab.registeredLabs(studentID);
    if (studentLabList !=null) 
    {
   	 	lab.PrintTable(studentLabList);
    }
    else 
    {
    	System.out.println("Student Not registered in any Lab");
    }
    }
    else
    {
    	System.out.println("Provide Valid Input");
    }	
}

}
