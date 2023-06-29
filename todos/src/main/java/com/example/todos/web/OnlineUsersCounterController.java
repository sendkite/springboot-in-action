package com.example.todos.web;

import com.example.todos.web.support.ConnectedClientCountBroadcaster;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Controller
public class OnlineUsersCounterController {

    private final ConnectedClientCountBroadcaster broadcaster = new ConnectedClientCountBroadcaster();

    /*
     * HTML5 Server-sent events(https://en.wikipedia.org/wiki/Server-sent_events) 스펙을 구현
     */
    @RequestMapping(path = "/stream/online-users-counter", produces = "text/event-stream")
    public void counter(HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/event-stream");

        for (int number=1; number<11; number++) {
            TimeUnit.SECONDS.sleep(1);

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(("data: " + number + "\n\n").getBytes());
            outputStream.flush();
        }
    }
}
