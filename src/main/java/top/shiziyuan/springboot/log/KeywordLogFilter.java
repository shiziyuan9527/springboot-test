package top.shiziyuan.springboot.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class KeywordLogFilter extends Filter<ILoggingEvent> {
    private String keyword;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getMessage().contains(keyword)) {
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
