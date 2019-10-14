package com.library.service;

import com.library.exception.NoSuchStudentException;
import com.library.model.Student;
import com.library.repository.StudentRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static final Logger LOGGER = LogManager.getLogger(StudentService.class.getName());

    @Autowired
    private StudentRepo studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
        LOGGER.info("Student has been added to database");
    }

    public void updateStudent(Student student) {
            studentRepo.findById(student.getId()).ifPresentOrElse(student1 -> {
                studentRepo.save(student);
                LOGGER.info("Student has been updated");
            }, () -> {
                throw new NoSuchStudentException("No student found with id=" + student.getId());
            });
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id)
                .orElseThrow(new NoSuchStudentException("No student found with id=" + id));
    }

    public void deleteStudent(int id) {
        studentRepo.findById(id).ifPresentOrElse(student -> {
            studentRepo.deleteById(id);
            LOGGER.info("Student with id=" + id + " has been deleted from database");
        }, () -> {
            LOGGER.error("NO STUDENT FOUND WITH ID=" + id);
            throw new NoSuchStudentException("No student found with id=" + id);
        });

    }

}
