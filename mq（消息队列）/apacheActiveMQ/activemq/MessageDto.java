package activemq;

import java.io.Serializable;

public class MessageDto implements Serializable{
    private String top;
    private String msg;
    public MessageDto(){

    }
    public MessageDto(String top, String msg) {
        this.top = top;
        this.msg = msg;
    }
    public String getTop() {
        return top;
    }
    public void setTop(String top) {
        this.top = top;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "标题：" +  this.top + "  " + "内容：" + this.msg;
    }
}
