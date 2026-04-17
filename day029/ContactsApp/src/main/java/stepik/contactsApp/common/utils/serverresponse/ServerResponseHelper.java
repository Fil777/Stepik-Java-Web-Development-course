package stepik.contactsApp.common.utils.serverresponse;

import stepik.contactsApp.model.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerResponseHelper {
    public static <T> ResponseEntity<ServerResponse<T>> ok(T result, HttpStatus httpStatus) {
        ServerResponse<T> response =
                ServerResponse.<T>builder()
                        .result(result)
                        .statusCode(httpStatus)
                        .isSuccess(true)
                        .errorMessages(new ArrayList<>())
                        .build();
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response);
    }

    public static <T> ResponseEntity<ServerResponse<T>> ok(T result) {
        return ok(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ServerResponse<T>> error(
            T result,
            HttpStatus httpStatus,
            List<String> errorMessages) {
        ServerResponse<T> response =
                ServerResponse.<T>builder()
                        .result(result)
                        .statusCode(httpStatus)
                        .isSuccess(false)
                        .errorMessages(errorMessages)
                        .build();
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response);
    }

    public static <T> ResponseEntity<ServerResponse<T>> errorSingle(T result, HttpStatus httpStatus, String message) {
        return error(result, httpStatus, Collections.singletonList(message));
    }

    public static <T> ResponseEntity<ServerResponse<T>> notFound(T result, String message) {
        return errorSingle(result, HttpStatus.NOT_FOUND, message);
    }

    public static <T> ResponseEntity<ServerResponse<T>> notFound(T result) {
        return notFound(result, "Данные не найдены");
    }

    public static <T> ResponseEntity<ServerResponse<T>> notFound() {
        return notFound(null, "Данные не найдены");
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict (T result, String message){
        return errorSingle(result, HttpStatus.CONFLICT, message);
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict (T result, List<String> messages){
        return error(result, HttpStatus.CONFLICT, messages);
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict (List<String> messages){
        return error(null, HttpStatus.CONFLICT, messages);
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict (T result){
        return conflict(result, "Конфликт при выполнении операции");
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict (String message){
        return errorSingle(null, HttpStatus.CONFLICT, message);
    }

    public static <T> ResponseEntity<ServerResponse<T>> conflict (){
        return conflict(null, "Конфликт при выполнении операции");
    }

}
