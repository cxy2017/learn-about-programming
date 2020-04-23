package com.cxyup.core.message;

import com.cxyup.core.service.SearchService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 消息处理类
 */
public class CustomMessageListener implements MessageListener{

    @Autowired
    private SearchService searchService;
    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage am= (ActiveMQTextMessage) message;
        try {
//            System.out.println("ActiveMQ中的消息是:"+am.getText());
            //保存商品到solr服务器
            searchService.insertProductToSolr(Long.parseLong(am.getText()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
