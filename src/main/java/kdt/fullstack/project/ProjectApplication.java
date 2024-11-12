package kdt.fullstack.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"kdt.fullstack"} )
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}

// 마무리 navbar 헤더로 빼고 세션따라서 username, 로그아웃으로 변경,
// 계정마다 고유 번호 만들기 date.now()로 지정
// details먼저 만들고 추천. 비추 만들기
// 추천, 비추천을 기록하려면 영화db가 추가로필요.. ? 제목+개봉일로 이름만 저장해서 뽑아야 할듯
// 추천, 비추천한 유저의 고유 코드를 영화db에 저장? 개개인의 유저 디테일에 제목+개봉일로 어떤 영화를 추천, 비추천한지 기록
// 