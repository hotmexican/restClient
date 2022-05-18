package com.client.communication;

import com.client.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class Communication {

    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/timeTracker/api/students";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/")
    public String showAllStudents(Model model) {
        ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Student>>() {
                });
        List<Student> studentList = responseEntity.getBody();
        model.addAttribute("allStudents", studentList);
        return "first_view";
    }

    public Student getStudent(int id) {
        return null;
    }

    public void saveStudent(Student student) {
    }

    public void deleteStudent(int id) {

    }

}
