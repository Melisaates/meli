package com.development.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.development.springbootbackend.model.Student;


@Repository
public interface IStudentRepo extends JpaRepository<Student,Long>{
	

}
