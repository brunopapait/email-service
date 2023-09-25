package br.com.papait.bruno.emailservice.application.controller;

import br.com.papait.bruno.emailservice.application.EmailSenderUseCaseImpl;
import br.com.papait.bruno.emailservice.core.EmailRequest;
import br.com.papait.bruno.emailservice.core.exceptions.EmailServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailSenderController {

  private final EmailSenderUseCaseImpl emailSenderUseCaseImpl;

  @PostMapping("/sendEmail")
  public ResponseEntity<String> sendEmail(@RequestBody final EmailRequest emailRequest) {
    try {
      this.emailSenderUseCaseImpl.execute(emailRequest.to(), emailRequest.subject(), emailRequest.body());

      return ResponseEntity.ok().body("Email sent successfully!");
    } catch (EmailServiceException emailServiceException) {
      return ResponseEntity.internalServerError().body(emailServiceException.getMessage());
    }
  }
}
