package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String SEPARATOR = ";";

    static class People {
        int id, salary;
        String name, gender, birthday, subdivision;

        public People(int id, String name, String birthday, String gender, String subdivision, int salary) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.gender = gender;
            this.salary = salary;
            this.subdivision = subdivision;
        }
    }
    public static void main(String[] args) {
        String csvFilePass = "foreign_names.csv";
        ArrayList<People> list = new ArrayList<People>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(csvFilePass));
            scanner.next();
            //scanner.useDelimiter(SEPARATOR);
            while (scanner.hasNext()) {
                People tmp = parseCSVLine(scanner.next());
                if (tmp != null) {
                    list.add(tmp);
                }

            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
        finally {
            assert scanner != null;
            scanner.close();
            for (People tmp:
                    list) {
                System.out.println(tmp.id + " " + tmp.name + " " + tmp.gender
                        + " " + tmp.birthday + " " + tmp.subdivision + " " + tmp.salary);
            }
        }
    }

    private static People parseCSVLine(String line) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(SEPARATOR);
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                if (scanner.hasNext()) {
                    String name = scanner.next();
                    if (scanner.hasNext()) {
                        String gender = scanner.next();
                        String birthday = scanner.next();
                        String subdivision = scanner.next();
                        int salary = scanner.nextInt();
                        return new People(id, name, birthday, gender, subdivision, salary);
                    }
                }
            }
            return null;
    }
}
