package com.rachit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rachit.model.Details;
import com.rachit.model.User;

public interface DetailsRepository extends JpaRepository<Details, Integer> {

	@Query("select distinct store_name from Details where user_name=?1")
	public List<String> findByUser(String username);
	
	@Query("select  book_id, book_name, book_count from Details where user_name=?1 and store_name=?2")
	public List<Object[]> findByStore(String username,String store);
	
	@Modifying  
	@Query("update Details set book_count=?1 where user_name=?2 and store_name=?3 and book_name=?4")
	@Transactional
	public void updateInventoryByBook(int count, String username,String store, String bookname);
	
	@Modifying  
	@Query("delete from Details where user_name=?1 and store_name=?2 and book_name=?3")
	@Transactional
	public void deleteInventoryByBook(String user_name, String store, String book_name);
	
}
