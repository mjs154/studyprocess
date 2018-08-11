package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 生产者
 */
public class ProducerPus {
    public static void main(String[] args) throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        try {
            //1.创建ConnectionFactory  连接工厂
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://198.181.47.219:61616");
            //2.创建Connection 连接对象
            connection = connectionFactory.createConnection();
            //开启连接
            connection.start();
            //3.创建Session会话，该会话用于创建消息生产者、消息消费者和消息等
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //4.创建Destination 目的地对象
            Destination destination = session.createTopic("jms_producer_pub/sub");
            //5.创建消息的生产者
            messageProducer = session.createProducer(destination);
            //6.创建一条消息
            ObjectMessage objMessage = session.createObjectMessage(new MessageDto("pub/sub", "我是主题发布者"));
            //7.发送消息
            messageProducer.send(objMessage);
            //提交事务
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //8.释放资源
            messageProducer.close();
            session.close();
            connection.close();
        }
    }
}
