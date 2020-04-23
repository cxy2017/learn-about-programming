package com.cxyup.core.message;


import com.cxyup.core.bean.product.Color;
import com.cxyup.core.bean.product.Product;
import com.cxyup.core.bean.product.Sku;
import com.cxyup.core.service.CmsService;
import com.cxyup.core.service.staticpage.StaticPageService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;


import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.*;

/**
 * 消息处理类
 */
public class CustomMessageListener implements MessageListener{


    @Autowired
    private StaticPageService staticPageService;
    @Autowired
    private CmsService cmsService;

    @Override
    public void onMessage(Message message) {
        ActiveMQTextMessage am= (ActiveMQTextMessage) message;
        try {
            String id=am.getText();
            //数据
            Map<String,Object> root=new HashMap<>();
            //商品
            Product product = cmsService.selectProductById(Long.parseLong(id));
            //sku
            List<Sku> skus = cmsService.selectSkuListByProductById(Long.parseLong(id));
            Set<Color> colors=new HashSet<>();
            for (Sku sku:
                    skus) {
                colors.add(sku.getColor());
            }
            root.put("skus",skus);
            root.put("product",product);
            root.put("colors",colors);
            //静态化
            staticPageService.productStaticPage(root,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
