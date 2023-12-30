package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;

import ch.qos.logback.core.util.FixedDelay;

@Service
public class UserService {


private static final Logger log = LoggerFactory.getLogger(UserService.class);
Thread t= new Thread();

UserModel user = new UserModel();
@Async("taskExecutor")
@Scheduled(fixedDelay = 1000)
public List<UserModel> getEmpList1() throws InterruptedException{
	List<UserModel> EmpList1=new ArrayList<>();
	for (int i = 0; i < 20; i++) {
		Thread.sleep(1000);	 
		user.setId(1001);
		user.setName("Muthu");
		user.setEmail("muthu123@gmail.com");
		user.setGender("male");
		EmpList1.add(user);
		log.info( t.getName(), t.getState());	 
	}
	return EmpList1;	
}
@Async("taskExecutor")
public List<UserModel> getEmpList2() throws InterruptedException
{	

//    String cron_expression="0 0/1 * * * ?"; 
    
    
	List<UserModel> EmpList2=new ArrayList<>();
	for (int i = 0; i <20; i++) {
		Thread.sleep(1000);
			user.setId(2001);
			user.setName("selvan");
			user.setEmail("selvan@gmail.com");
			user.setGender("male");
			log.info( t.getName(), t.getState());			 
	}	
	EmpList2.add(user);
	return EmpList2;
}
@Async("taskExecutor")
@Scheduled(fixedDelay = 3000)
public List<UserModel> getEmpList3() throws InterruptedException
{
	List<UserModel> EmpList3=new ArrayList<>();
		for (int i = 0; i <20; i++) {
			 user.setId(3001);
			user.setName("Vishva");
			user.setEmail("Vishva@gmail.com");
			user.setGender("male");
			log.info( t.getName(), t.getState());
	}
	EmpList3.add(user);
	return EmpList3;
}
@Async("taskExecutor")
@Scheduled(fixedDelay = 4000)
public List<UserModel> getEmpList4() throws InterruptedException
{
	List<UserModel> EmpList4=new ArrayList<>();
	for (int i = 0; i <20; i++) {
	Thread.sleep(1000);
		user.setId(4001);
		user.setName("Ram");
		user.setEmail("Ram@gmail.com");
		user.setGender("male");
		EmpList4.add(user);	
		 log.info( t.getName(), t.getState());	 
	}
	return EmpList4;	
}
}

  
		







































//
//@Autowired
//private UserRepository repository;
//
//Object target;
//Logger logger = LoggerFactory.getLogger(UserService.class);
//
//@Async
//public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
//    long start = System.currentTimeMillis();
//    List<User> users = parseCSVFile(file);
//    logger.info("saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
//    users = repository.saveAll(users);
//    long end = System.currentTimeMillis();
//    logger.info("Total time {}", (end - start));
//    return CompletableFuture.completedFuture(users);
//}
//@Async
//public CompletableFuture<List<User>> findAllUsers(){
//    logger.info("get list of user by "+Thread.currentThread().getName());
//    List<User> users=repository.findAll();
//    return CompletableFuture.completedFuture(users);
//}
//
//private List<User> parseCSVFile(final MultipartFile file) throws Exception {
//    final List<User> users = new ArrayList<>();
//    try {
//        try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                final String[] data = line.split(",");
//                final User user = new User();
//                user.setName(data[0]);
//                user.setEmail(data[1]);
//                user.setGender(data[2]);
//                users.add(user);
//            }
//            return users;
//        }
//    } catch (final IOException e) {
//        logger.error("Failed to parse CSV file {}", e);
//        throw new Exception("Failed to parse CSV file {}", e);
//    }