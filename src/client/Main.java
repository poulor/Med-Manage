package client;

public class Main {

    public static void main(String[] args) throws Exception{
        Patient p = new Patient("John", "Doe", "Male", 18, "11/21/1998", "here", "911");

        System.out.println(p);

        p.setHeight(72);
        p.setWeight(180);
        p.addHealthHistory("Diabetes");
        p.addMedications("tylenol");
        p.addNotes("Good guy!");

        System.out.println(p);

    }

}
