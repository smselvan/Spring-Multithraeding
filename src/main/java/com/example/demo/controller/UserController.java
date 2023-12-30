package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
public class UserController extends Thread{
	
	@Autowired UserService service;
	
	@GetMapping("/getEmpList")
	  public  String findEmpList()throws InterruptedException, ExecutionException {	
		service.getEmpList1();
		service.getEmpList2();
		service.getEmpList3();
		service.getEmpList4();
		return "Processs Staterd";
	}
	

}















































//@Autowired
//private UserService service;
//
//@PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
//public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
//    for (MultipartFile file : files) {
//        service.saveUsers(file);
//    }
//    return ResponseEntity.status(HttpStatus.CREATED).build();
//}
//
//@GetMapping(value = "/users", produces = "application/json")
//public CompletableFuture<ResponseEntity> findAllUsers() {
//   return  service.findAllUsers().thenApply(ResponseEntity::ok);
//}
//
//
//@GetMapping(value = "/getUsersByThread", produces = "application/json")
//public  ResponseEntity getUsers(){
//    CompletableFuture<List<User>> users1=service.findAllUsers();
//    CompletableFuture<List<User>> users2=service.findAllUsers();
//    CompletableFuture<List<User>> users3=service.findAllUsers();
//    CompletableFuture.allOf(users1,users2,users3).join();
//    return  ResponseEntity.status(HttpStatus.OK).build();
//}