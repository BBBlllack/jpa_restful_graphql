package com.shj.restfulgraphql.api;


import com.shj.restfulgraphql.entity.ApiResponse;
import com.shj.restfulgraphql.entity.Author;
import com.shj.restfulgraphql.entity.Book;
import com.shj.restfulgraphql.repositories.AuthorRepository;
import com.shj.restfulgraphql.repositories.BookRepository;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class BookGraphQL {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @QueryMapping
    public Book getBookById(@Argument Long id) {
        log.info("GetBook id is {}", id);
        return bookRepository.findById(id).orElseGet(() -> {
            Book book = new Book();
            book.setId(0L);
            book.setName("default");
            book.setAuthorId(0L);
            return book;
        });
    }

    /**
     * query BookDetails{
     *   getBookById(id: 1){
     *     id
     *     name
     *     pages
     *     author{ // 要和方法名相同
     *       id
     *       name
     *     }
     *   }
     * }
     * @param book
     * @return
     */
    @SchemaMapping
    public Author author(Book book){
        log.info("author id is {}",book.getAuthorId());
        return authorRepository.findById(book.getAuthorId()).orElseGet(()-> null);
    }
}
