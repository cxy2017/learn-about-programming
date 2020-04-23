package com.cxyup;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestSolr
{
    @Autowired
    private SolrServer solrServer;
    @Test
    public void testSolrJSpring() throws Exception{
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id",24);
        doc.setField("name","小玲玲2");
        solrServer.add(doc);
        solrServer.commit();
    }
    @Test
    public void TestSolrJ()throws Exception{
        SolrServer solrServer=new HttpSolrServer("http://192.168.200.128:8080/solr");
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id",3);
        doc.setField("name","小玲玲");
        solrServer.add(doc);
        solrServer.commit();
    }
}
