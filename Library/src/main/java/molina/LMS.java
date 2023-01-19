package molina;



import java.util.Scanner;
class bookNotFoundException extends Exception{
	public bookNotFoundException(String s) {
		super(s);
	}
}
abstract class Details
{
	String Name ;
	String Gender ;
	String Address ;
	void entry(String Name, String Gender,String Address) {}
	
}

class Student1 extends Details{
	Student1(){
		System.out.println("Welcome to our library");
	}
	Student1(String Name){
		System.out.println("Feel Welcomed "+Name);
		
	}
{
		//System.out.println("Welcome dear Student");
	}

	void entry(String Name, String Gender,String Address) {
	System.out.println("Student Name: "+Name+"  Gender: "+ Gender+"  Address: "+Address);
	}
	

}
class Teacher1 extends Details{
	Teacher1(){
		System.out.println("Welcome to our library");
	}
	Teacher1(String Name){
		System.out.println("Feel Welcomed "+Name);
	}

	void entry(String Name, String Gender,String Address) {
		System.out.println("Teacher Name: "+Name+"  Gender: "+ Gender+"  Address: "+Address);
		}
	
}
class Book
{
    String title;
    Boolean flag = false;
    int rating = 0;
    int sum[]= {0};
    int avg =0;
    
}
class Library{
    Book[] v = new Book[10];
    
    int i = 5;
    void currentInventory(){
    	 v[0] = new Book();
         v[0].title = "Atomic Habits";
         v[1] = new Book();
         v[1].title = "Looking for Alaska";
         v[2] = new Book();
         v[2].title = "Harry potter: The Sorcerer's stone";
         v[3] = new Book();
         v[3].title = "The Alchemist";
         v[4] = new Book();
         v[4].title = "Murakami";
         
    }
    void addBook(String title)
    {
        v[i] = new Book();
        v[i].title = title;
        i++;
        System.out.println(title+" Succesfully added to libarary");
    }

    void checkOut(String title)
    {try {
        Boolean checked_out = false;
        for (int j = 0; j < i; j++)
        {
            if (v[j].title.equals(title) && v[j].flag == false)
            {
                v[j].flag = true;
                checked_out = true;
            }
        }
        if (checked_out == false)
        	
        {
        	throw new bookNotFoundException("Sorry the book is unavailable");
            
        }
        else
        {
            System.out.println("Thank you, enjoy reading " + title);
        }
    }
    catch(bookNotFoundException e) {
    System.out.println("Exception Caught");
    
    // Print the message from MyException object
    System.out.println(e.getMessage());
    }

    }

    void returnBook(String title)
    {
        boolean check_return = true;
        for (int k = 0; k < i; k++)
        {
            if (v[k].title.equals(title) && v[k].flag)
            {
                v[k].flag = false;
                System.out.println("Thank you!");
                check_return= false;
            }
        }
        if (check_return)
        {
            System.out.println("This book wasn't checked out.");
        }
    }

    void receiveRating(String title, int point)
    {
        boolean present = false;
        for (int l = 0; l < i; l++)
        {
            if (v[l].title.equals(title))
            {
            	if (v[l].title.equals(title))
                {
                    v[l].rating = point;
                    present = true;
                }
            }
        }
        
        if (!present)
        {
            System.out.println("This Book is unavailable");
        }
    }

    void listInventory()
    {
        int serial = 1;
        for (int m = 0; m < i; m++)
        {
            if (!v[m].flag)
            System.out.println(serial++ + ". Book: " + v[m].title + "; Rating: " + v[m].rating);
        }
    }
}

class LMS
{
    public static void main(String[] args)
    {
    	   Scanner sc = new Scanner(System.in);

    	 System.out.println("Enter Name ");
    	   String Name = sc.nextLine();
    	   System.out.println("Enter gender ");
    	   String Gender = sc.nextLine();
    	   System.out.println("Enter Address ");
    	   String Address = sc.nextLine();
    	   System.out.println("Enter Occupation ");
    	   String occ = sc.nextLine();
    	   if(occ.equalsIgnoreCase("Teacher")) {
    		   

    		   Teacher1 T1 = new Teacher1(Name);
    		   T1.entry(Name, Gender,Address);
    		   
    	   }
    	   else if(occ.equalsIgnoreCase("Student"))
    	   
    	   {
    		   
    		   Student1 S1 = new Student1(Name);
    		   S1.entry(Name, Gender,Address);
    		   
    		   
    	   }

        int menu = 1;
        Library vs = new Library();
        vs.currentInventory();
        while (menu != 0)
        {
            System.out.println("\n1. Add Book\n2. Check Out\n3. Return Book\n4. Rate Book\n5. Book List\n6. Exit");
            sc=new Scanner(System.in);
            System.out.println("Enter menu: ");
            menu = sc.nextInt();
            switch (menu)
            {
                case 1:
                {
                    System.out.println("Add Book: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    vs.addBook(title);
                    break;
                }
                case 2:
                {
                    System.out.println("Book: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    vs.checkOut(title);
                    break;
                }
                case 3:
                {
                    System.out.println("Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    vs.returnBook(title);
                    break;
                }
                case 4:
                {
                    System.out.println("Book Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.println("Rating: ");
                    int points = sc.nextInt();
                    while (1 > points || points > 5)
                    {
                        System.out.println("Rate between 1 to 5: ");
                        points = sc.nextInt();
                    }
                    vs.receiveRating(title, points);
                    break;
                }
                case 5:
                {
                    vs.listInventory();
                    break;
                }
                case 6:
                {
                    System.out.println("Thank you, visit again!");
                    menu = 0;
                    break;
                }
            }
        }
    }
}









