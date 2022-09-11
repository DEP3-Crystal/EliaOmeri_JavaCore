import java.util.*;

//  1.We declare an arraylist of students with higher probability of being chosen
//    who haven't been chosen before
//  2.We declare another arraylist which will have the students chosen before except the last one,so will contain
//  the students with less probability of being chosen
//  3.We declare a temporary variable which will contain the last chosen student
//  4. last random chosen will go to tmp variable and the value of tmp will go to the second arraylist
//  5.we declare and initialize with 10 a variable and pick a random number from(0-99)
//if  number is between 0-10 so lower posibilities it will pick a student from lowerChancesArray that are picked once
//if number is between  10-100 random choose between not chosen students which are in the first arraylist
// everytime the low list gets full of 5 students the first student arrived will be transfered to high list
public class RandomChoiceWithProbability {
    public static void main(String[] args) {
                List<String> highWeightStudents = new ArrayList<>(Arrays.asList(
                        "isuf.muca@crystal-system.eu",
                        "danjel.halili@crystal-system.eu",
                        "flavio.lorenci@crystal-system.eu",
                        "elia.omeri@crystal-system.eu",
                        "ardit.elezi@crystal-system.eu",
                        "luka.buziu@crystal-system.eu",
                        "megi.lala@crystal-system.eu",
                        "irena.shahini@crystal-system.eu",
                        "indrit.vaka@crystal-system.eu",
                        "griselda.muci@crystal-system.eu",
                        "theodor.gheorghe@crystal-system.eu",
                        "ioan.cocianu@crystal-system.eu",
                        "teofil.mitrea@crystal-system.eu",
                        "eduard.tiutiu@crystal-system.eu",
                        "george.dobrota@crystal-system.eu",
                        "stefanita.plesa@crystal-system.eu",
                        "adrian-nicolae.tigau@crystal-system.eu",
                        "emanuel.grabovschi@crystal-system.eu",
                        "george.sirbu@crystal-system.eu",
                        "andrei.state@crystal-system.eu",
                        "florin-adrian.dumitru@crystal-system.eu",
                        "victor.hincu@crystal-system.eu"));//elements with high weight goes here
                Random r = new Random();
                ArrayList<String> lowWeightStudents = new ArrayList<>();//element choosen lastly will go here
                int choosen = r.nextInt(highWeightStudents.size()); //last choosen student
                System.out.println(highWeightStudents.get(choosen));
                int temp = 0;
                String ans;
                do {
                    System.out.println("Do you want to make another random choice? Type Y if yes");
                    Scanner in = new Scanner(System.in);
                    ans = (in.next().charAt(0) + "").toLowerCase();

                    //first we check if the low... isn't empty
                    if (!lowWeightStudents.isEmpty()) {

                        int randomNumber = r.nextInt(100); // get a number randomly from 0-99
                        if (randomNumber <= 10) {
                            choosen = r.nextInt(lowWeightStudents.size());
                            System.out.println(lowWeightStudents.get(choosen));

                        } else {
                            temp = choosen; // tmp will get the last second chosen student
                            choosen = r.nextInt(highWeightStudents.size()); //choosen will get the last choosen student
                            if (choosen == temp) {
                                System.out.println("Same student as last time!");
                            }
                            System.out.println(highWeightStudents.get(choosen));

                            lowWeightStudents.add(highWeightStudents.get(temp)); //tmp will be added to low arraylist
                            if (lowWeightStudents.size() == 5) {
                                highWeightStudents.add(lowWeightStudents.get(0));
                                lowWeightStudents.remove(0);
                            }
                        }

                    } else {
                        temp = choosen;
                        choosen = r.nextInt(highWeightStudents.size());
                        System.out.println(highWeightStudents.get(choosen));
                        lowWeightStudents.add(highWeightStudents.get(temp));
                        highWeightStudents.remove(temp);
                    }
                } while (ans.equals("y"));

            }


        }