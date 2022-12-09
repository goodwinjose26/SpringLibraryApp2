package com.example.springlibrary_backend.controller;


import com.example.springlibrary_backend.dao.CustomersDao;
import com.example.springlibrary_backend.dao.LibraryDao;
import com.example.springlibrary_backend.model.Customers;
import com.example.springlibrary_backend.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {
    @Autowired
    private LibraryDao dao;

    @Autowired
    private CustomersDao dao1;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json", produces = "application/json")
    public Map<String,String> add(@RequestBody Library l)
    {
        //System.out.println(s.toString());
        dao.save(l);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
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


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/reg",consumes = "application/json",produces = "application/json")
    public Map<String,String> reg(@RequestBody Customers c)
    {
        dao1.save(c);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<Customers> login(@RequestBody Customers c)
    {
        String username=String.valueOf(c.getUsername());
        String password=String.valueOf(c.getPassword());
        return (List<Customers>) dao1.login(username,password);

    }



}
