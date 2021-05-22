package net.marco27.api.websockets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebSocketPriceOut {
    private String source;
    private String instrument;
    private String variation;
}
