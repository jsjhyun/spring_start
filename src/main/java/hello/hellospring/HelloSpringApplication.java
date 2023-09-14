package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 가장 먼저 실행되는 클래스
public class HelloSpringApplication {

	public static void main(String[] args) {
		// 가장 먼저 실행되는 메소드는 메인 -> static이라 메모리에 가장 먼저 올라감
		SpringApplication.run(HelloSpringApplication.class, args); // 스트링부트 사용하겠다는 이니셜라이징
	}

}
