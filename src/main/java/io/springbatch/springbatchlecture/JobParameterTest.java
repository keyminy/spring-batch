package io.springbatch.springbatchlecture;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JobParameterTest implements ApplicationRunner{
    
	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*JobParametersBuilder를 통해 JobParameter생성합니다.*/
		JobParameters jobParameters = new JobParametersBuilder()
			.addString("name","user1")
			.addLong("seq", 2L)
			.addDate("date", new Date())
			.addDouble("age", 16.5)
			.toJobParameters();
		//jobLauncher를 이용해 job을 실행해보자
		jobLauncher.run(job, jobParameters);
	}
}