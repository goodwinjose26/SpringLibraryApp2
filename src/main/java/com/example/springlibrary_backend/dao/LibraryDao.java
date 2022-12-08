package com.example.springlibrary_backend.dao;

import com.example.springlibrary_backend.model.Library;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibraryDao extends CrudRepository<Library,Integer> {

    @Query(value ="SELECT `id`, `author`, `booktitle`, `description`, `price`, `publisher` FROM `books` WHERE `booktitle`=:booktitle",nativeQuery = true )
    List<Library> searchBook(@Param("booktitle") String booktitle);
}
