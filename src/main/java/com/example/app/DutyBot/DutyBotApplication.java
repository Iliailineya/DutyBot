package com.example.app.DutyBot;

import com.example.app.DutyBot.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class DutyBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DutyBotApplication.class, args);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Controller());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
