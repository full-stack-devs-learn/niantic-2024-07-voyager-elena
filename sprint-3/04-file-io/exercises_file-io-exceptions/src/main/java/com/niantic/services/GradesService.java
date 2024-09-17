package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.Student;

import java.util.List;

public interface GradesService
{
    String[] getFileNames();

    Student getStudentAssignments(String fileName);

    List<Assignment> getAllAssignments(String[] fileNames);
}
