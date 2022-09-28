package top.shiziyuan.springboottest.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.encoder.Encoder;

import java.nio.charset.StandardCharsets;

public class ConsoleAppender<E> extends UnsynchronizedAppenderBase<E> {

    private Encoder encoder;

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void append(E e) {
        ILoggingEvent event = (ILoggingEvent) e;
        byte[] bytes = this.encoder.encode(e);
        String log = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(log);
    }
}
