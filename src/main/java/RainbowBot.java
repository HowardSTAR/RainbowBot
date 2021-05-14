import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class RainbowBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        AllTags(update);
        pdrBot(update);
    }

    private void pdrBot(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

            }
        }
    }

    private void AllTags(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/all@SixRainbowBot")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("ПОГНАЛИ В РАДУГУ \uD83C\uDF08 ПАЧАНЫ: "); // sendMessage.setText("ПОГНАЛИ В РАДУГУ ПАЧАНЫ\n @LtNice @VmiakoV @Rekane @faraboh @grSeva");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());

                    //InlineKeyboardButton
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> inlineButtonsList = new ArrayList<>();
                    List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
                    List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
                    List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();

                    keyboardButtonsRow1.add(inlineKeyboardButton1.setText("Дениска").setCallbackData("@LtNice"));
                    keyboardButtonsRow1.add(inlineKeyboardButton2.setText("Вадик").setCallbackData("@VmiakoV"));
                    keyboardButtonsRow2.add(inlineKeyboardButton3.setText("Севка").setCallbackData("@grSeva"));
                    keyboardButtonsRow2.add(inlineKeyboardButton4.setText("Фара").setCallbackData("@faraboh"));
                    keyboardButtonsRow3.add(inlineKeyboardButton5.setText("Сява").setCallbackData("@Rekane"));
                    keyboardButtonsRow3.add(inlineKeyboardButton6.setText("ОБЩИЙ СБОР").setCallbackData("@allGAY"));

                    inlineButtonsList.add(keyboardButtonsRow1);
                    inlineButtonsList.add(keyboardButtonsRow2);
                    inlineButtonsList.add(keyboardButtonsRow3);

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
                sendMessage.setText("@LtNice");
            }
            else if (data.equals("@grSeva")) {
                sendMessage.setText("@grSeva");
            }
            else if (data.equals("@VmiakoV")) {
                sendMessage.setText("@VmiakoV");
            }
            else if (data.equals("@Rekane")) {
                sendMessage.setText("@Rekane");
            }
            else if (data.equals("@faraboh")) {
                sendMessage.setText("@faraboh");
            }
            else if (data.equals("@allGAY")) {
                sendMessage.setText("@LtNice @VmiakoV @Rekane @faraboh @grSeva");
            }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "SixRainbowBot";
    }

    public String getBotToken() {
        return "1765246757:AAH5HHdXh-iouxiP-laxvLUjixgMxcaLlCQ";
    }
}
