package stepik.ContactsApp.controller;

import stepik.ContactsApp.common.utils.serverresponse.ServerResponseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stepik.ContactsApp.model.ServerResponse;

@RestController
@RequestMapping("/api/test")
public class TestController {

    // http://localhost:8080/api/contacts/foo1
    @GetMapping("/foo1")
    public ResponseEntity<ServerResponse<String>> foo1() {
        return ServerResponseHelper.ok("foo1");
    }
    // http://localhost:8080/api/contacts/foo2
    @GetMapping("/foo2")
    public ResponseEntity<ServerResponse<String>> foo2() {
        return ServerResponseHelper.notFound("foo2");
    }

}
