package com.backend.pvcbpayment.repository;

import com.backend.pvcbpayment.entity.Users;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users,Integer> {
    Users getUsersById(Integer id);
    List<Users> findAllByOrderById();

    @Query(value = "select * from users where phone=:phone",nativeQuery = true)
    List<Users> getUserByPhone(@Param("phone") String phone);

    @Query(value = "select * from users where cmt_number like %:idCard%",nativeQuery = true)
    List<Users> getUserByIDCard(@Param("idCard") String idCard);



}
