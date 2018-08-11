package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;

public class ConsumerSub {
    public static void main(String[] args) throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageConsumer messageConsumer = null;
        try {
            //1.创建ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://198.181.47.219:61616");
            //2.创建Connection
            connection = connectionFactory.createConnection();
            connection.start();
            //3.创建Session
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //4.创建Destination 目的地对象
            Destination destination = session.createTopic("jms_producer_pub/sub");
            //5.创建消费者
            messageConsumer = session.createConsumer(destination);
            //6.消费消息
            while(true){
                ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
                msg = (ActiveMQObjectMessage) messageConsumer.receive(10000);
                if(null != msg){
                    MessageDto dto = (MessageDto) msg.getObject();
                    System.out.println(dto.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //7.释放资源
            System.out.println("执行完毕");
            messageConsumer.close();
            session.close();
            connection.close();
        }
    }
}
