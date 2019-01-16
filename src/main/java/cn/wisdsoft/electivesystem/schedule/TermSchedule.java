package cn.wisdsoft.electivesystem.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;

@Component
public class TermSchedule {
	
	private final TermResourceMapper termResourceMapper;
	
	@Autowired
	public TermSchedule(TermResourceMapper termResourceMapper) {
		this.termResourceMapper = termResourceMapper;
	}
	
	@Scheduled(cron = "0 0 */1 * * ?")
	private void viewTerm() {
		termResourceMapper.updateTermResourceByCloseTime();
	}
}
