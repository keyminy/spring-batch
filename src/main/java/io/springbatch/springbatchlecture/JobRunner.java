package io.springbatch.springbatchlecture;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component //Bean으로 만들어줌
public class JobRunner implements ApplicationRunner{
	//ApplicationRunner : 부트 초기화 시 가장 먼저 호출합니다.
	//ApplicationRunner의 run()메서드를 호출하게 됩니다.
	
	@Autowired
	//JobLauncher : Job을 실행시킴,Bean으로 등록되어있기땜에 의존성 주입 받을 수 있어요
	private JobLauncher jobLauncher;
	
	//우리가 구성한 BatchJob을 의존성 주입 받습니다.
	@Autowired
	private Job job;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		JobParameters jobParameters =  new JobParametersBuilder()
			.addString("name", "user1")
			.toJobParameters(); // JobParametersBuilder객체를 얻는다.
		
		//jobLauncher를 이용해 job을 실행해보자
		jobLauncher.run(job, jobParameters);
	}
}
