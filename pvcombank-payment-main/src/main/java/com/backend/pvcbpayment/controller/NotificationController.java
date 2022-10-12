package com.backend.pvcbpayment.controller;

import com.backend.pvcbpayment.entity.NotificationContens;
import com.backend.pvcbpayment.entity.TokenNotification;
import com.backend.pvcbpayment.model.Note;
import com.backend.pvcbpayment.repository.NotificationContensRepository;
import com.backend.pvcbpayment.repository.TokenNotificationRepository;
import com.backend.pvcbpayment.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class NotificationController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    @Autowired
    TokenNotificationRepository notificationRepository;

    @Autowired
    NotificationContensRepository notificationContensRepository ;


//    @RequestMapping("send-notification")
//    @ResponseBody
//    public String sendNotification(@RequestBody Note note,
//                                   @RequestParam String token) throws FirebaseMessagingException {
//        return firebaseMessagingService.sendNotification(note, token);
//    }

    String token ="ffgzfA_2RtO1nTA4MjkT6U:APA91bGFxB21Ji0aQKzr1DdiQY8YGIDYxrGGfVevjJldUzCplnBFYsbUiibrTWs8rvp1YT0Ro7XniGR9Gvr9Nd_MY52PGz7-X0Ggk8js5mUZFe64EvuQ1bpSAc9VayFAcrQg2hgWFTkL";

    @PostMapping(value = "send-notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendNotification(@RequestBody Note note)  {
        LOGGER.info("call send-notification");
        try {
            return new ResponseEntity<>(firebaseMessagingService.sendNotification(note), HttpStatus.OK);
        } catch (FirebaseMessagingException e) {
            LOGGER.error("send-notification fail " + e);
            return new ResponseEntity<>("Fail cant save token", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "save-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveToken(@RequestBody TokenNotification notification){
        try {
            LOGGER.info("saveToken start");
            notificationRepository.save(notification);
            LOGGER.info("saveToken ok");
        } catch (Exception e){
            LOGGER.error("saveToken fail " + e);
            return new ResponseEntity("Fail cant save token", HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }
        return new ResponseEntity("save-token success",HttpStatus.OK);
    }

    @PostMapping(value = "send-list-notification", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendListNotification(@RequestBody Note note) throws FirebaseMessagingException {

        LOGGER.info("call send-notification");
        return firebaseMessagingService.sendListNotification(note);
        //return note.getContent();
    }

    @PostMapping(value = "save-conten",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveConten(@RequestBody NotificationContens notification){
        try {
            LOGGER.info("saveToken start");
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date parseDate = format.parse(format.format(new Date()));
            notification.setDate_create(new Date());
            notificationContensRepository.save(notification);
            LOGGER.info("saveToken ok");
        } catch (Exception e){
            LOGGER.error("saveToken fail " + e);
            return new ResponseEntity("Fail cant save token", HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }
        return new ResponseEntity("save-token success",HttpStatus.OK);
    }

    @GetMapping(value = "contens",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NotificationContens>> getListContens(){
        try {
            LOGGER.info("getListContens start");
            return new ResponseEntity(notificationContensRepository.findAll(), HttpStatus.OK);

        } catch (Exception e){
            LOGGER.error("getListContens fail " + e);
            return new ResponseEntity("Fail cant getListContens", HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }

    }

    @DeleteMapping(value = "delete-conten/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteConten(@PathVariable(value = "id") int id){
        try {
            LOGGER.info("delete-conten start");
            notificationContensRepository.deleteById(id);
            LOGGER.info("delete-conten ok");
        } catch (Exception e){
            LOGGER.error("delete-conten fail " + e);
            return new ResponseEntity("Fail cant delete-conten", HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }
        return new ResponseEntity("delete-conten success",HttpStatus.OK);
    }

}
