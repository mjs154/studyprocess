package activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;

/**
 * 消费者（接收消息的JMS）
 */
public class Consumer {
    public static void main(String[] args) throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageConsumer messageConsumer = null;
        try{
            //1.创建ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://198.181.47.219:61616");
            //2.创建Connection
            connection = connectionFactory.createConnection();
            connection.start();
            //3.创建Session
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //4.创建Destination 目的地对象
            Destination destination = session.createQueue("jms_producer_p2p");
            //5.创建消费者
            messageConsumer = session.createConsumer(destination);
            int number = 0;
            //6.消费消息，最多消费五条
            while(true){
                /**
                 * 接收消息，并且指定超时时间为10s阻塞时间，超时返回null
                 */
                ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
                msg = (ActiveMQObjectMessage) messageConsumer.receive(10000);
                if(null != msg){
                    number ++ ;
                    MessageDto dto = (MessageDto) msg.getObject();
                    System.out.println(dto.toString());
                }
                if (number > 5)
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //7.释放资源
            messageConsumer.close();
            session.close();
            connection.close();
        }
    }
}
