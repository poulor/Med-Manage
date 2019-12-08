package client;

public class Main {

    public static void main(String[] args) throws Exception{
        Patient p = new Patient("John", "A", "Doe", "Male", "10/31/2003", "800000000", "21 Here St.", 10000, "jdoe", "password", "Patient", 70, 165, "", "", 21);
        
        Patient q = new Patient("Jane", "A", "Doe", "Male", "10/31/2003", "800000000", "21 Here St.", 10000, "jdoe", "password", "Patient", 70, 165, "", "", 21);
        System.out.println(p);
        System.out.println(q.getFirstName());
        

    }

}
