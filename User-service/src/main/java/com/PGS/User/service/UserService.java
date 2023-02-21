package com.PGS.User.service;


import com.PGS.User.VO.Department;
import com.PGS.User.VO.ResponseTemplateVO;
import com.PGS.User.entity.User;
import com.PGS.User.repository.userRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("Inside save user of UserService");
        return userRepository.save(user);
    }
    public  ResponseTemplateVO serviceFallback(Exception e){
        log.info("servicefallbackmethod");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        vo.setMessage("THIS IS A FALL BACK PAGE FOR USER-SERVICE");
        return vo;
    }
    @CircuitBreaker(name="user-service",fallbackMethod="serviceFallback")

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:9002/departments/" + user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}