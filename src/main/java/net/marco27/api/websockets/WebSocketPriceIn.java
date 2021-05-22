package net.marco27.api.websockets;

import lombok.Data;

@Data
public class WebSocketPriceIn {
    private String source;
    private String instrument;
}
