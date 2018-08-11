package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;

/**
 * 生产者(创建并发送消息)
 */
public class Producer {
    public static void main(String[] args) throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        try{
            //1.创建ConnectionFactory  连接工厂
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://198.181.47.219:61616");
            //2.创建Connection 连接对象
            connection = connectionFactory.createConnection();
            //开启连接
            connection.start();
            //3.创建Session会话，该会话用于创建消息生产者、消息消费者和消息等
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //4.创建Destination 目的地对象
            Destination destination = session.createQueue("jms_producer_p2p");
            //5.创建消息的生产者
            messageProducer = session.createProducer(destination);
            //6.创建一条消息
            ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
            msg.setObject(new MessageDto("p2p", "我是点对点模式发布者"));
            //7.发送消息
            messageProducer.send(msg);
            //提交事务
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //8.释放资源
            messageProducer.close();
            session.close();
            connection.close();
        }
    }
}
