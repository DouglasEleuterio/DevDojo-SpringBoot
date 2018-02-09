package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.error.CustomErrorType;
import br.com.devdojo.awesome.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("students")
public class StudentEndpoint {


    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public ResponseEntity<?> listAll(){

        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id")int id){
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);

        if(index == -1) {
            return new ResponseEntity<>(new CustomErrorType("Estudent not found"), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
        }

    }

}

