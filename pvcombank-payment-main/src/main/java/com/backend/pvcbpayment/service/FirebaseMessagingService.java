package com.backend.pvcbpayment.service;

import com.backend.pvcbpayment.entity.TokenNotification;
import com.backend.pvcbpayment.model.Note;
import com.backend.pvcbpayment.repository.TokenNotificationRepository;
import com.backend.pvcbpayment.repository.UsersRepository;
import com.google.firebase.messaging.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirebaseMessagingService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final FirebaseMessaging firebaseMessaging;
    List<String> failedTokens = new ArrayList<>();

    List<String> registrationTokens = new ArrayList<>();

    @Autowired
    TokenNotificationRepository notificationRepository;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }
    public String sendNotification(Note note) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .setImage(note.getImage())
                .build();

        Message message = Message
                .builder()
                .setToken(note.getToken())
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);
    }

    public String sendListNotification(Note note) throws FirebaseMessagingException {
        int n = (int)Math.ceil(getCount()/200.0);
        for (int x = 0; x<=n; x++ ){

            Pageable pageable =  PageRequest.of(x+1,200);

            Notification notification = Notification
                    .builder()
                    .setTitle(note.getSubject())
                    .setBody(note.getContent())
                    .setImage(note.getImage())
                    .build();
            List<String> v =getListToken(pageable);
            MulticastMessage message = MulticastMessage.builder()
                    .setNotification(notification)
    //                .putData("score", "850")
    //                .putData("time", "2:45")
                    .addAllTokens(getListToken(pageable))
                    .build();

            BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
            if (response.getFailureCount() > 0) {
                List<SendResponse> responses = response.getResponses();

                for (int i = 0; i < responses.size(); i++) {
                    if (!responses.get(i).isSuccessful()) {
                        // The order of responses corresponds to the order of the registration tokens.
                        failedTokens.add(registrationTokens.get(i));
                    }
                }
                LOGGER.info("List of tokens that caused failures: " + failedTokens);
            }


//            System.out.println("bbbb " + getListToken(pageable).stream().count());
       }

        return  "List of tokens that caused failures: " + failedTokens ;
    }

    private List<String> getListToken(Pageable pageable){
        return notificationRepository.getListToken(pageable);
    }

    public long getCount(){
        return notificationRepository.count();
    }

}
