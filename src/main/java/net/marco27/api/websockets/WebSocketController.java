package net.marco27.api.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public WebSocketPriceOut send(final WebSocketPriceIn webSocketPriceIn) throws Exception {
        return new WebSocketPriceOut(webSocketPriceIn.getSource(), webSocketPriceIn.getInstrument(), "TODO");
    }
}
