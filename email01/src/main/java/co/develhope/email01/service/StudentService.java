package co.develhope.email01.service;

import co.develhope.email01.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//defines a StudentService that has:
//a list of 4 Students, where the first one is you (with your email)
//a method getStudentById that returns the Student if it's present in the list

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "Linda", "Amadei", "linda@gmail.co"),
            new Student("2", "Claudio", "Zeta", "claudio@gmail.co" ),
            new Student("3", "Ary", "Rossi", "ary@gmail.co"),
            new Student("4", "Gab", "Blu", "gab@gmail.co" )
    );

    public  Student getStudentById(int studentId){
        Student studentFromDB = students.stream().filter(student -> student.getId().equals(studentId)).findAny();
    //   for (Student studentFromDB : students) {
        //            if (studentFromDB.getId().equals(studentId)) {
        //                return studentFromDB;
        //            }
        //        }
        if (studentFromDB.isPresent()) return studentFromDB.get();
        return null;
    }
}

