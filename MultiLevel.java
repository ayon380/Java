import java.util.Scanner;
class Mid_Sem {
    int mid_maths, mid_science, mid_english, mid_social;
    Mid_Sem(){
        System.out.println("Mid Sem Marks");
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Maths Marks");
        mid_maths = sc.nextInt();
        System.out.println("Enter Science Marks");
        mid_science = sc.nextInt();
        System.out.println("Enter English Marks");
        mid_english = sc.nextInt();
        System.out.println("Enter Social Marks");
        mid_social = sc.nextInt();
    }
}

class End_Sem extends Mid_Sem {
    int end_maths, end_science, end_english, end_social;
    End_Sem(){
        System.out.println("End Sem Marks");
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Maths Marks");
        end_maths = sc.nextInt();
        System.out.println("Enter Science Marks");
        end_science = sc.nextInt();
        System.out.println("Enter English Marks");
        end_english = sc.nextInt();
        System.out.println("Enter Social Marks");
        end_social = sc.nextInt();
    }
}

class Results extends End_Sem {
    int total;
    void show(){
        total = mid_maths + mid_science + mid_english + mid_social + end_maths + end_science + end_english + end_social;
        System.out.println("\t\t\tSRM University AP\n\n");
        System.out.println("\t\t\t\tMarks Sheet\n\n");
        System.out.println("\t\t\tMid Sem Marks\t\tEnd Sem Marks");
        System.out.println("Maths\t\t\t"+mid_maths+"\t\t\t"+end_maths);
        System.out.println("Science\t\t\t"+mid_science+"\t\t\t"+end_science);
        System.out.println("English\t\t\t"+mid_english+"\t\t\t"+end_english);
        System.out.println("Social\t\t\t"+mid_social+"\t\t\t"+end_social);
        System.out.println("Total\t\t\t"+total+" out of 800");
    }
}

public class MultiLevel {
    public static void main(String[] args) {
        Results vc2 = new Results();
        vc2.show();
    }
}
