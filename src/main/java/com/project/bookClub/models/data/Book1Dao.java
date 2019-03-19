package com.project.bookClub.models.data;

import com.project.bookClub.models.Book;
import com.project.bookClub.models.Book1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface Book1Dao extends CrudRepository<Book1, Integer> {
}
