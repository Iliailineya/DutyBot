package com.example.app.DutyBot.controller;

import com.example.app.DutyBot.util.Storage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

@org.springframework.stereotype.Controller
public class Controller extends TelegramLongPollingBot {
    Storage storage;
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    private static final Logger LOGGER =
            Logger.getLogger(Controller.class.getName());


    public Controller() {
        storage = new Storage();
        initKeyboard();
    }

    void initKeyboard() {
        //Создаем объект будущей клавиатуры и выставляем нужные настройки
        replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true); //подгоняем размер
        replyKeyboardMarkup.setOneTimeKeyboard(false); //скрываем после использования

        //Создаем список с рядами кнопок
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        //Создаем один ряд кнопок и добавляем его в список
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        //Добавляем одну кнопку с текстом "Просвети" наш ряд
        keyboardRow.add(new KeyboardButton("Просвети"));
        //добавляем лист с одним рядом кнопок в главный объект
        replyKeyboardMarkup.setKeyboard(keyboardRows);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();
                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                String response = parseMessage(inMess.getText());
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage outMess = new SendMessage();

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);

                //Отправка в чат
                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String textMsg) {
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if (textMsg.equals("/start")) {
            response = "Приветствую, бот знает много цитат. Жми /get, чтобы получить случайную из них";
        } else if (textMsg.equals("/get")) {
            response = storage.getRandQuote();
        } else {
            response = "Сообщение не распознано";
            LOGGER.info("Сообщение не распознано: " + textMsg);
        }


        return response;
    }

    @Override
    public String getBotUsername() {
        FileReader fr;
        String BOT_NAME;
        try {
            fr = new FileReader("src/main/java/credential/BOT_NAME");
            Scanner scan = new Scanner(fr);
            BOT_NAME = scan.nextLine();

            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        FileReader fr;
        String BOT_TOKEN;
        try {
            fr = new FileReader("src/main/java/credential/BOT_TOKEN");
            Scanner scan = new Scanner(fr);
            BOT_TOKEN = scan.nextLine();

            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return BOT_TOKEN;
    }
}