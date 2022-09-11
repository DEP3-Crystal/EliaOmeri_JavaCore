import java.util.*;
    public class RandomChoice {
        static Random r = new Random();
        static List<String> highWeightStudents = new ArrayList<>(Arrays.asList(
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
                "victor.hincu@crystal-system.eu",
                "stefan.ruci@crystal-system.eu"));
        public static void main(String[] args) {
            //elements with high weight goes here
            ArrayList<String> lowWeightStudents = new ArrayList<>();//element choosen lastly will go here
            int choosen = r.nextInt(highWeightStudents.size()); //last choosen student

            System.out.println(highWeightStudents.get(choosen));
            lowWeightStudents.add(highWeightStudents.get(choosen));

            Scanner in = new Scanner(System.in);
            String answer;
            do {
                System.out.println("Do you want to make another random choice? \n Type Y if yes or n for exit \n Type p to see previous choosen people \n Type n to exit");
                answer = (in.next().charAt(0) + "").toLowerCase();

                if (answer.equals("n")) {
                    break;
                } else if (answer.equals("p")) {
                    System.out.println("Students that are chosen");
                    System.out.println(lowWeightStudents);
                    //first we check if the low... isn't empty
                } else if (answer.equals("y")) {
                    choosen=pickRandom(highWeightStudents);

                    while (lowWeightStudents.contains(highWeightStudents.get(choosen))){
                        choosen=pickRandom(highWeightStudents);
                    }
                    System.out.println(highWeightStudents.get(choosen));
                    lowWeightStudents.add(highWeightStudents.get(choosen));
                }
                if (highWeightStudents.size()==lowWeightStudents.size()){
                    lowWeightStudents.clear();
                }
            } while (!answer.equals("n"));
        }

        public static int pickRandom(List<String> list) {
            return r.nextInt(list.size());
        }
    }

