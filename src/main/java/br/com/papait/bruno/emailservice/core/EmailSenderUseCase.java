package br.com.papait.bruno.emailservice.core;

public interface EmailSenderUseCase {
  void execute(final String to, final String subject, final String body);
}
