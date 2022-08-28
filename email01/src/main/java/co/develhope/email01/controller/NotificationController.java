package co.develhope.email01.controller;

//exposes under the mapping notification an endpoint for sending an email to a specific Student
//use a try/catch in the dedicated controller
//if the id of the Student is already in the list, then send the email to that user
//if not, reply with a BAD_REQUEST message
//if the request is not correct, reply with an error 500 HTTP response

import co.develhope.email01.model.NotificationDTO;
import co.develhope.email01.model.Student;
import co.develhope.email01.service.EmailService;
import co.develhope.email01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;

    @PostMapping ("/notification")
    public ResponseEntity sendNotification (@RequestBody NotificationDTO payload){
        try{
            Student studentSendNotification = studentService.getStudentById(payload.getContactId());
            System.out.println("");
            if (studentSendNotification == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student don't find");
            }
            emailService.sendTo(studentSendNotification.getEmail(), payload.getTitle(), payload.getText());
                    return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            System.err.println("Error 500 HTTP: " + e.getMessage());
            e.printStackTrace();
        }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }


}
