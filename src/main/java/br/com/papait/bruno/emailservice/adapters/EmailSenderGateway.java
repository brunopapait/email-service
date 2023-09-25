package br.com.papait.bruno.emailservice.adapters;

public interface EmailSenderGateway {
  void sendEmail(final String to, final String subject, final String body);
}
