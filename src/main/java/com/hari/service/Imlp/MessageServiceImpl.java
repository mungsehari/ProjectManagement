package com.hari.service.Imlp;

import com.hari.model.Chat;
import com.hari.model.Message;
import com.hari.model.User;
import com.hari.repository.MessageRepository;
import com.hari.repository.UserRepository;
import com.hari.service.MessageService;
import com.hari.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectService projectService;

    @Override
    public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {

        User sender=userRepository.findById(senderId).orElseThrow(()->new Exception("User no found with id"+senderId));

        Chat chat=projectService.getProjectById(projectId).getChat();
        Message message=new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);
        Message savedMessage=messageRepository.save(message);

        chat.getMessages().add(savedMessage);


        return savedMessage;
    }

    @Override
    public List<Message> getMessageByProjectId(Long projectId) throws Exception {
        Chat chat=projectService.getChatById(projectId);

        return messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId());
    }
}
