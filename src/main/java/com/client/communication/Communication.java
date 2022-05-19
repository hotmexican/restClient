package com.client.communication;

import com.client.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class Communication {

    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8081/timeTracker/api/students";

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
        Student student = restTemplate.getForObject(URL + "/" + id, Student.class);
        return null;
    }

    @RequestMapping("/addNewStudent")
    public String addNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student_view";
    }
    @RequestMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        restTemplate.postForEntity(URL, student, String.class);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateStudent(@RequestParam("studentId") int id, Model model){
        Student student = restTemplate.getForObject(URL + "/" + id, Student.class);
        model.addAttribute("student", student);
        restTemplate.put(URL, student);
        return "add_student_view";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int id) {
        restTemplate.delete(URL + "/" + id);
        return "redirect:/";
    }

}
