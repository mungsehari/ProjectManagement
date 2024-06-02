package com.hari.controller;

import com.hari.model.Chat;
import com.hari.model.Message;
import com.hari.model.User;
import com.hari.request.CreateMessageRequest;
import com.hari.service.MessageService;
import com.hari.service.ProjectService;
import com.hari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request) throws Exception {
        User user=userService.findUserById(request.getSenderId());

        Chat chats= projectService.getProjectById(request.getProjectId()).getChat();
        if (chats==null) throw  new Exception("Chat not found with id ");
        Message sendMessage=messageService.sendMessage(request.getSenderId(),request.getProjectId(),request.getContent());
        return ResponseEntity.ok(sendMessage);
    }

    @GetMapping("/chat/{projectId}")
    public  ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable Long projectId) throws Exception {
        List<Message> messages=messageService.getMessageByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }



}
