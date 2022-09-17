package ec.edu.ups.messagingwebsocket;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    // logs
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GreetingController.class);

    @MessageMapping("/hello") // el path donde se va a recibir el mensaje
    @SendTo("/topic/greetings") // el path donde se va a enviar el mensaje
    public Greeting greeting(String message){
        // string to object
        Gson gson = new Gson();
        Data msg = gson.fromJson(message, Data.class);

        log.info("GreetingController.greeting: "+msg.toString());
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(msg.toString()));
    }

}
