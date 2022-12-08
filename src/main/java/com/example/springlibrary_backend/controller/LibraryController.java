package com.example.springlibrary_backend.controller;


import com.example.springlibrary_backend.dao.LibraryDao;
import com.example.springlibrary_backend.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json", produces = "application/json")
    public String add(@RequestBody Library l)
    {
        //System.out.println(s.toString());
        dao.save(l);
        return  "student details added successfully";
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
//    public List<Library> searchBook(@RequestBody Library l)
//    {
//        String booktitle=String.valueOf(l.getBooktitle());
//        System.out.println(booktitle);
//        return (List<Library>) dao.searchBook(l.getBooktitle());
//    }





}
