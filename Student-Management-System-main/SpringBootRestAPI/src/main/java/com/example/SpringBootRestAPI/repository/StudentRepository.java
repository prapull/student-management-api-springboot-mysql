package com.example.SpringBootRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootRestAPI.entity.student;

public interface StudentRepository extends JpaRepository<student, Integer>{

}
