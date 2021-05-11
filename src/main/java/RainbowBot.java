import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RainbowBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot{

    public String getBotUsername() {
        return "SixRainbowBot";
    }

    public String getBotToken() {
        return "1765246757:AAH5HHdXh-iouxiP-laxvLUjixgMxcaLlCQ";
    }

    public void onUpdateReceived(Update update) {

            if (update.hasMessage()) {
                Message message = update.getMessage();

                  if(message.hasText()) {
                  String text = message.getText();

                    if (text.equals("/all")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setText("ПОГНАЛИ В РАДУГУ ПАЧАНЫ\n @LtNice @VmiakoV @Rekane @faraboh @grSeva");
                        sendMessage.setParseMode(ParseMode.MARKDOWN);
                        sendMessage.setChatId(message.getChatId());

                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }

        }
    }
}
