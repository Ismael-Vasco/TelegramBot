package es.codegym.telegrambot;

//importar una hoja de java
import static es.codegym.telegrambot.TelegramBotContent.FINAL_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_1_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_2_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_3_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_4_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_5_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_6_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_7_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_8_TEXT;


import java.util.Map;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;



public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymChatBot_bot";
    public static final String TOKEN = "7139786962:AAFLCii5MDIvKMbeD6xRJmuym2jHB8voAJs";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if  (getMessageText().toLowerCase().equals("/start")){
            setUserGlory(0);

            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Romper la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);

            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Toma una salchicha! +20 de fama", "step_2_btn",
                    "Toma un pescado! +20 de fama", "step_2_btn",
                    "Tirar una lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        if  (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear el robot aspiradora", "step_3_btn"));
        }

        if  (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspiradora por la comida! +30 de fama", "step_4_btn",
                    "Dar un paseo en el robot aspiradora! +30 de fama", "step_4_btn",
                    "Huir del robot aspiradora! +30 de fama", "step_4_btn"));
        }

        if  (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, 
                    Map.of("Encender y ponerse la GoPro!", "step_5_btn"));
        }

        if  (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, 
                    Map.of("Correr por los tejados, grabar con la GoPro! +40 de fama", "step_6_btn",
                    "Atacar a otros gatos desde tu escondite con la GoPro! +40 de fama", "step_6_btn",
                    "Atacar a los perros desde tu escondite con la GoPro! +40 de fama", "step_6_btn"));
        }
        
        if  (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(50);
            
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, 
                    Map.of("hackea la contraseña de la computadora!", "step_7_btn"));
        }

        if  (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, 
                    Map.of("Has superado la computadora!", "step_8_btn"));
        }

        if  (getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(50);
            
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT, 
                    Map.of());
        }





       /*  if  (getMessageText().toLowerCase().contains("hola") || 
        getMessageText().toLowerCase().contains("hi") || 
        getMessageText().toLowerCase().contains("hello")){

            sendTextMessageAsync("hi, What's your name?");
        }

        if  (getMessageText().toLowerCase().contains("me llamo") || 
        getMessageText().toLowerCase().contains("mi nombre es") || 
        getMessageText().toLowerCase().contains("my name is" ) || 
        getMessageText().toLowerCase().contains("i am") || 
        getMessageText().toLowerCase().contains("i'm")){

            sendTextMessageAsync("Great, nice to meet you!, my name is GATO");
        }
        */


        
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}