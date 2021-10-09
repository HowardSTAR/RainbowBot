import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.ChatMember;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class RainbowBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {

    public void onUpdateReceived(Update update){
        try {
            AllTags(update);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        pdrBot(update);
    }


    /*
    Главный функционал – отвечает на рандомные сообщения,
    беря от туда одно слово и образоывая фразу "*слово* для пидоров"
    */
    private void pdrBot(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

//                if(text.equals("хейт")){
//                    SendMessage sendMessage = new SendMessage().setChatId(message.getChatId()).setText(text);
//                    ForwardMessage forwardMessage = new ForwardMessage().setChatId(message.getChatId());
//
//                    forwardMessage.getMessageId();
//
//                    sendMessage.setParseMode(ParseMode.MARKDOWN);
//                    sendMessage.setChatId(message.getChatId());
//
//                    message.getFrom().getUserName();
//
//                    sendMessage.setText("ПЯУ");
////                    message.getReplyToMessage().isReply();
//
//                    try {
//                        execute(sendMessage);
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }
    }

    private void AllTags(Update update) throws TelegramApiException {
        ChatMember chatMember = new ChatMember();
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/all@SixRainbowBot") || text.equals("/all")) {
                    SendMessage sendMessage = new SendMessage().setChatId(message.getChatId()).setText(text);
                    sendMessage.setText("ПОГНАЛИ В РАДУГУ \uD83C\uDF08 ПАЧАНЫ: "); // emoji Rainbow
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());

                    message.getForwardSenderName();

                    //InlineKeyboardButton
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> inlineButtonsList = new ArrayList<>();

                    List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
                    List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
                    List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
                    List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();

                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();

//                    ReplyKeyboardMarkup butt = new ReplyKeyboardMarkup();

                    keyboardButtonsRow1.add(inlineKeyboardButton1.setText("Дениска").setCallbackData("@LtNice"));
                    keyboardButtonsRow1.add(inlineKeyboardButton2.setText("Вадик").setCallbackData("@VmiakoV"));
                    keyboardButtonsRow2.add(inlineKeyboardButton3.setText("Севка").setCallbackData("@grSeva"));
                    keyboardButtonsRow2.add(inlineKeyboardButton4.setText("Фара").setCallbackData("@faraboh"));
                    keyboardButtonsRow3.add(inlineKeyboardButton5.setText("Сява").setCallbackData("@Rekane"));
                    keyboardButtonsRow3.add(inlineKeyboardButton6.setText("Илюха").setCallbackData("@qwertyspamer"));
                    keyboardButtonsRow4.add(inlineKeyboardButton7
                            .setText("\uD83C\uDFF3️\u200D\uD83C\uDF08Гей парад\uD83C\uDFF3️\u200D\uD83C\uDF08") //emoji pride flag
                            .setCallbackData("@allGAY"));

                    inlineButtonsList.add(keyboardButtonsRow1);
                    inlineButtonsList.add(keyboardButtonsRow2);
                    inlineButtonsList.add(keyboardButtonsRow3);
                    inlineButtonsList.add(keyboardButtonsRow4);

                    inlineKeyboardMarkup.setKeyboard(inlineButtonsList);

                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            Message message = update.getCallbackQuery().getMessage();

            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            SendMessage sendMessage = new SendMessage().setParseMode(ParseMode.MARKDOWN).setChatId(message.getChatId());

            if (data.equals("@LtNice")) {
                sendMessage.setText("@LtNice – жопа Дениса");
                deleteMethod(update);
            }
            else if (data.equals("@grSeva")) {
                sendMessage.setText("@grSeva – погнали");
                deleteMethod(update);
            }
            else if (data.equals("@VmiakoV")) {
                sendMessage.setText("@VmiakoV – только тебя ждем");
                deleteMethod(update);
            }
            else if (data.equals("@Rekane")) {
                sendMessage.setText("@Rekane – любимка");
                deleteMethod(update);
            }
            else if (data.equals("@faraboh")) {
                sendMessage.setText("@faraboh – идем рейтинг сливать");
                deleteMethod(update);
            }
            else if (data.equals("@qwertyspamer")) {
                sendMessage.setText("@qwertyspamer – давно не падали лицом в радугу");
                deleteMethod(update);
            }
            else if (data.equals("@allGAY")) {
                sendMessage.setText("Господа офицеры, долг зовёт – @LtNice @VmiakoV @Rekane @faraboh @grSeva @qwertyspamer");
                deleteMethod(update);
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteMethod(Update update){
        Message message = update.getCallbackQuery().getMessage();
        DeleteMessage deleteMessage = new DeleteMessage();

        deleteMessage.setChatId(message.getChatId());
        deleteMessage.setMessageId(message.getMessageId());
        try {
            execute(deleteMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String getBotUsername() {
        return "SixRainbowBot";
    }

    public String getBotToken() {
        return "1765246757:AAH5HHdXh-iouxiP-laxvLUjixgMxcaLlCQ";
    }
}
