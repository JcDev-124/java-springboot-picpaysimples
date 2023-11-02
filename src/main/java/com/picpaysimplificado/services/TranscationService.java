package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TranscationService {

    @Autowired
    UserService userService;
    @Autowired
    TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NortificationService nortificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findByUserId(transaction.senderId());
        User receiver = this.userService.findByUserId(transaction.receiverId());

        userService.validationTransaction(sender, transaction.value());

        boolean isAuthorize = this.authorizeTransaction(sender, transaction.value());
        if(!isAuthorize){
            throw new Exception("Transacao nao autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.nortificationService.sendNotification(sender, "Transacao enviada com sucesso");
        this.nortificationService.sendNotification(receiver, "Transacao recebida com sucesso");

        return newTransaction;

    }
    public boolean authorizeTransaction(User sender, BigDecimal value){
       ResponseEntity <Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

       if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
           String message = (String) authorizationResponse.getBody().get("message");
           return "Autorizado".equalsIgnoreCase(message);
       }
       return false;
    }
}
