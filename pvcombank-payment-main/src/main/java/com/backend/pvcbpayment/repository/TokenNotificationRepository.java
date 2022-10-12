package com.backend.pvcbpayment.repository;

import com.backend.pvcbpayment.entity.TokenNotification;
import com.backend.pvcbpayment.entity.Users;
import feign.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TokenNotificationRepository extends CrudRepository<TokenNotification,Integer> {
    @Query(value = "select token from token_notification \n-- #pageable\n",
            countQuery = "SELECT count(*) FROM token_notification",
            nativeQuery = true)
    List<String> getListToken(Pageable pageable);

}
