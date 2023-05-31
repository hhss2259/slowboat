package slowboat.slowboat.model.basic;

import lombok.Data;

@Data
public class DefaultRes <T>{
    private int statusCode;
    private String message;
    private T data;


    public DefaultRes(final int statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.data=null;
    }

    public DefaultRes(final int statusCode, final String message, T data){
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
    public static<T> DefaultRes<T> res(final int statusCode, final String message, T data){
        return new DefaultRes<T>(statusCode, message, data);
    }
    public static<T> DefaultRes<T> res(final int statusCode, final String message){
        return new DefaultRes<T>(statusCode, message);
    }
}
