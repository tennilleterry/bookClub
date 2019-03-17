package com.project.bookClub.models.data;

import com.project.bookClub.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, Integer> {
}
