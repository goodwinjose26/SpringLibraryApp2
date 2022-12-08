package com.example.springlibrary_backend.controller;


import com.example.springlibrary_backend.dao.LibraryDao;
import com.example.springlibrary_backend.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Library> searchBook(@RequestBody Library l)
    {
        String booktitle=String.valueOf(l.getBooktitle());
        System.out.println(booktitle);
        return (List<Library>) dao.searchBook(l.getBooktitle());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Library> view()
    {
        return (List<Library>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> deleteBook(@RequestBody Library l)
    {
        String id=String.valueOf(l.getId());
        System.out.println(id);
        dao.deleteBook(l.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }





}
