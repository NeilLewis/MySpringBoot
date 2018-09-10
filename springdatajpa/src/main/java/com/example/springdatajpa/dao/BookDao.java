package com.example.springdatajpa.dao;

import com.example.springdatajpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/***
 * JpaRepository 可以实现基本的crud及模糊查询/本地查询
 *JpaSpecificationExecutor 可以实现多条件查询
 */
public interface BookDao extends JpaRepository<Book,Integer>,JpaSpecificationExecutor<Book> {

    //模糊查询
    @Query("select b from Book b where  b.name like %?1%")
    public List<Book> findByName(String name);

    //随机查询两条数据(最好使用本地查询)
    @Query(value = "select * from t_book order by RAND() limit ?1",nativeQuery = true)
    public List<Book> randomList(int n);


}
